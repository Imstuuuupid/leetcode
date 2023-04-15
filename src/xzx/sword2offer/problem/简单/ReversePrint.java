package xzx.sword2offer.problem.简单;

import xzx.structure.ListNode;

import java.util.ArrayList;

/**
 * 从尾到头打印链表：
 *      输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class ReversePrint {

    private ArrayList<Integer> arrayList=new ArrayList<>();
    /**
     * 思路：
     *     套娃
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Matryoshka(head);
        int[] result= new int[arrayList.size()];
        for(int i=0;i<result.length;i++)
        {
            result[i]=arrayList.get(i);
        }
        return result;
    }

    public void Matryoshka(ListNode head)
    {
        if (head==null)
        {
            return ;
        }
        Matryoshka(head.next);
        arrayList.add(head.val);

    }
}
