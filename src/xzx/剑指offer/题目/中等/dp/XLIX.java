package xzx.剑指offer.题目.中等.dp;

import static java.lang.Math.min;

/**
 * 题目：丑数
 * <p>
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class XLIX {
    /**
     * 思路： 又是动态规划！！！
     * 三个丑数 2  3  5
     * 拿丑数*丑数=丑数，依次排序就好
     * 故做三个指针
     * 依次相乘取最小入数组
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = 2 * res[p2];
            int n3 = 3 * res[p3];
            int n5 = 5 * res[p5];
            res[i] = min(n2, min(n3, n5));
            if (res[i] == n2) {
                p2++;
            }
            if (res[i] == n3) {
                p3++;
            }
            if (res[i] == n5) {
                p5++;
            }
        }
        return res[res.length - 1];
    }
}
