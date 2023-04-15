package xzx.sword2offer.problem.简单;

import xzx.structure.ListNode;

/**
 * 题目：
 * 删除链表节点
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */
public class XVIII {

    /**
     * 思路：
     * 中规中矩，一个指针保存头结点
     * 一个指针保存当前节点，一个临时指针节点，
     * 把那个节点替换掉后删除，释放资源
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode h = head;
        ListNode pre = head;
        ListNode temp = pre;
        while (pre.val != val) {
            temp = pre;
            pre = pre.next;
        }
        temp.next = pre.next;
        return h;
    }
}
