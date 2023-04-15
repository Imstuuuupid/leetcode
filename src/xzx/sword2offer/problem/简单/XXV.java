package xzx.sword2offer.problem.简单;

import xzx.structure.ListNode;

/**
 * 题目：
 * 合并两个排序的链表
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class XXV {
    /**
     * 思路：
     * 两个链表做比较，小的先放，放完之后小的++，再与另一个做比较，递归直到两个指针都为空
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pr.next=l1;
                l1=l1.next;
            }else {
                pr.next=l2;
                l2=l2.next;
            }
            pr=pr.next;
        }
        pr.next=l1!=null?l1:l2;
        return head.next;
    }

}
