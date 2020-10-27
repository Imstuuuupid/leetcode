package xzx.sword2offer.problem.中等;

/**
 * 题目：
 * 数字序列中某一位数字
 *
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 *  
 *
 * 限制：
 *
 * 0 <= n < 2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class XLIV {
    /**
     * 思路：
     * 切割
     * 1~9 ：            1*9
     * 10~99：           10*9*2
     * 100~999：         100*9*3
     * 1000~9999：       1000*9*4
     *
     * start和count都要用long，不然会溢出
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        //位数从1开始
        int digits=1;
        //初始值是1，每次乘10
        long start=1;
        //计数器，判断n在哪个区间
        long count=9;
        while (n>count)
        {
            n-=count;
            digits+=1;
            start*=10;
            count=digits*start*9;
        }
        //出循环了，此时所在的区间以start开头，数字有digits位，
        // 在第start+(n-1)/digits个数字上，位数为(n-1)%digits
        long num=(n-1)/digits+start;
        //这里转成了ASCII码，所以减去'0'
        return Long.toString(num).charAt((n-1)%digits)-'0';
    }
}
