package xzx.sword2offer.problem.中等.递归;

/**
 * 题目：
 * 把数字翻译成字符串
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class XLVI {
    /**
     * 思路：
     * 整体来说就是递归，出口是num<=9 return 1;
     *
     * 个人理解里面还有枝剪，只是还咩有完全理解透，所以只贴出大佬的代码，
     * 慢慢理解吧。
     * @param num
     * @return
     */
    public int translateNum(int num) {
        if(num<=9) {
            return 1;
        }
        int ba=num%100;
        if(ba<=9||ba>=26)
        {
            return translateNum(num/10);
        }
        else
        {
            return translateNum(num/10)+translateNum(num/100);
        }

    }
}
