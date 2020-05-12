package xzx.剑指offer.题目.简单;

/**
 * 题目： 给定两串指针序列，逆序相加并以指针序列输出   指针序列中每个指针为一位数
 *
 * 思路：
 *      两数相加考虑进位，两串指针序列相加考虑长度，
 *      进位为1或0，每次相加之后更新进位，相加两序列时带上进位，即可。
 *      以长指针为标准，短指针数字遍历尽后，用0补位
 */
public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pre=new ListNode(0),curr=pre;
        int x=0;
        int y=0;
        int sum=0;
        int carry=0;
        while (l1!=null||l2!=null)
        {
            //判断当前指针是否为空，为空则补0
            x=l1==null?0:l1.val;
            y=l2==null?0:l2.val;
            //两指针序列相加、带上进位
            sum=x+y+carry;
            //更新进位，为1或0。
            carry=sum/10;
            //更新加数
            sum=sum%10;
            //将相加结果输入指针
            curr.next=new ListNode(sum);
            //两指针后移，遍历
            if(l1.next!=null)
            {
                l1=l1.next;
            }
            if(l2.next!=null)
            {
                l2=l2.next;
            }

        }
        //最后一组数相加，如果有进位则再添加进结果指针序列
        if(carry==1)
        {
            curr.next=new ListNode(carry);
        }
        //返回结果指针序列
        return pre;
    }

    private class ListNode {
        private Integer val;
        ListNode next;
        ListNode(int i)
        {
            val=i;
        }
    }
}
