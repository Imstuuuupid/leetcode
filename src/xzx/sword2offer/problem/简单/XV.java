package xzx.sword2offer.problem.简单;

/**
 * 题目：
 * 二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例
 * 如，把 9 表示成二进制是 1001，有 2 位是 1。
 * 因此，如果输入 9，则该函数输出 2。
 */
public class XV {
    /**
     * 思路：
     * n-1的时候，二进制中最右一位1变0，然后此位右边的所有0变1
     * n&(n-1)的时候，这些0变1的位置又全变为0，即这个操作消除了最右边的1
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }
}
