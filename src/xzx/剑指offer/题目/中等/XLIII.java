package xzx.剑指offer.题目.中等;

import static java.lang.StrictMath.pow;

/**
 * 题目：
 * 1~n整数中1出现的次数
 * <p>
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：6
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n < 2^31
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class XLIII {
    /**
     * 思路：
     * 找规律、拆分
     * 1-9贡献一个1，1-99贡献20个1，1-999贡献300个1
     * 所有数组拆为一位一位的，然后与positon里面对应
     * 拆到0了，就不管，更新其他数字
     * 拆到1了，就算一次position和之前的所有数组和+1
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        //位数对应的1贡献数，随着循环递增
        int[] position = {0, 1, 20, 300, 4000, 50000, 600000, 7000000, 80000000, 900000000};
        int count = 0;
        //记录之前的数字和
        int pre = 0;
        int res = 0;
        int pow = 1;
        while (n != 0) {
            int num = n % 10;
            if (num == 1) {
                res += position[count] + pre + 1;
            }
            if (num > 1) {
                //不是1，所有在这一位1xxx的时候贡献了pow个1
                res += num * position[count] + pow;
            }
            //计数，从低位到高位计数
            pre += pow * num;
            pow *= 10;
            n = n / 10;
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 31));

    }
}
