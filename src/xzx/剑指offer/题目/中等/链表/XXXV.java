package xzx.剑指offer.题目.中等.链表;

import xzx.剑指offer.题目.结构.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 */

public class XXXV {
    /**
     * 思路：
     * 做一个map辅助
     * 先遍历一遍，把原链表和复制链表存入map，这一遍只放入next
     * 再遍历一遍，把原链表的random和复制链表的random同步一次
     * 结束
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Map<Node,Node> map=new HashMap<>();
        Node temp=head;
        //这里只是创建了新的结点，但是没有连接他们的next
        while (temp!=null)
        {
            map.put(temp,new Node(temp.val));
            temp=temp.next;
        }
        temp=head;
        //连接next和random
        while (temp!=null)
        {
            map.get(temp).next=map.get(temp.next);
            map.get(temp).random=map.get(temp.random);
            temp=temp.next;
        }
        return map.get(head);
    }

    /**
     * 超时
     * @param head
     * @return
     */
    public Node failed(Node head)
    {
        if(head==null)
        {
            return null;
        }
        Node result=new Node(head.val);
        Node resT=result;
        Node headT=head;
        Map<Node,Node> map=new HashMap<>();
        map.put(head,result);
        while (headT.next!=null)
        {
            resT.next=new Node(headT.next.val);
            headT=headT.next;
            resT=resT.next;
            map.put(headT,resT);
        }
        resT=result;
        headT=head;
        while (headT.next!=null)
        {
            if(headT.random!=null)
            {
                // headH.random指向head中的随机一个结点，
                // 这个结点通过map获取对应result中的结点，赋给result的random
                resT.random=map.get(headT.random);
                resT=resT.next;
                headT=headT.next;
            }
        }
        return result;

    }
}
