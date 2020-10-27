package xzx.sword2offer.problem.简单;

import xzx.sword2offer.problem.structure.ListNode;

/**
 * 题目：
 * 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 */
public class XXIV {
    /**
     * 思路：
     * 遍历，然后头插法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
        {
            return head;
        }
        //尾部
        ListNode p=new ListNode(head.val);
        p.next=null;
        ListNode pre=null;
        while (head.next!=null)
        {
            head=head.next;
            pre=new ListNode(head.val);
            pre.next=p;
            p=pre;
        }
        return pre;
    }
}
