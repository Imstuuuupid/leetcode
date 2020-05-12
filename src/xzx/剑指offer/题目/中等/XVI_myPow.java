package xzx.剑指offer.题目.中等;

/**
 * 题目：
 * 数值的整数次方
 * <p>
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 */
public class XVI_myPow {
    /**
     * 思路：
     * 递归+分治思想
     *
     * 要注意的地方就在于int n要用long N来进行代替，因为有溢出
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            return 1 / stepPow(x, -N);
        }
        return stepPow(x, N);

    }

    double stepPow(double x, long n) {
        //这是递归到最底层了，都以1返回
        if (x == 1) {
            return 1;
        }
        if (n == 0) {
            return 1;
        }
        //偶数，返回自己*自己
        if ((n % 2) == 0) {
            //分治、分
            double res = stepPow(x, n / 2);
            //合
            return res * res;
        }
        //奇数
        else {
            double res = stepPow(x, (n - 1) / 2);
            return res * res * x;
        }
    }


}
