package xzx.剑指offer.题目.中等;

import static java.lang.Math.pow;

/**
 * 题目：
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。
 * 请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */

/**
 * （姊妹篇）
 * 题目：
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class XIIII_cuttingRope {
    /**
     * 思路：
     * 经过leetcode解题区大佬的数学推算，当取绳子长度为3且分多段时，能得到最大乘积
     * 因此肯定会有余数 1或者2
     * 当余数为1时，得到收益最低，应该与其中一段绳子重新分割为2+2
     * 当余数为2时，得到收益勉强可以接受。
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 2) {
            return (int) (pow(3, a) * 2);
        } else if (b == 1) {
            return (int) (pow(3, a - 1) * 4);
        }
        return (int) pow(3, a);
    }

    /**
     * 贪心算法
     * @param n
     * @return
     */
    public int cuttingRopeSecond(int n) {
        if(n == 2) {
            return 1;
        }
        if(n == 3){
            return 2;
        }
        //这个地方用int存储会出现越界，要用long
        long sum=1;
        int mod= (int) (1e9+7);
        while (n>4)
        {
            sum*=3;
            sum%=mod;
            n-=3;
        }
        return (int) (sum*n%mod);

    }
}
