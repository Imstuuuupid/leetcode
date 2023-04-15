package xzx.sword2offer.problem.简单;

import xzx.structure.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，
 * 从头节点开始，它们的值依次是1、2、3、4、5、6。
 * 这个链表的倒数第3个节点是值为4的节点。
 *
 */
public class XXII {

    /**
     * 思路，把遍历的每一个链表存放在一个map中，
     * 遍历完之后保存链表长度
     *
     * 上面是憨憨思路
     *
     * 双指针才是正解
     * 一个快指针，一个慢指针，让他们先相差k，然后同时移动到最后，返回慢指针
     * @param head
     * @param k
     * @return
     */

    public ListNode getKthFromEnd(ListNode head, int k) {
        Map<Integer,ListNode> listNodeMap=new HashMap<>();
        int count=0;
        while (head!=null)
        {
            listNodeMap.put(count,head);
            head=head.next;
            ++count;
        }
        return listNodeMap.get(count-k);
    }

    public ListNode getKthFromEnd_II(ListNode head, int k) {
        ListNode fast=head;
        ListNode slow=head;
        //快指针先跑k-1
        for(int i=0;i<k;i++)
        {
            fast=fast.next;
        }
        while (fast!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

    /**
     * 这个测试想证明，指针可以指向空
     * @param args
     */
//    public static void main(String[] args) {
//        ListNode test=new ListNode(0);
//        test.next=null;
//        ListNode e=test.next;
//        if(e==null)
//        {
//            System.out.println("null");
//        }
//    }

}
