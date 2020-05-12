package xzx.剑指offer.题目.简单;

/**
 * 上台阶的问题，一次可以上一节  可以上两节
 * 问上n节台阶有多少种上法
 */
public class numWays {

    /**
     * 同斐波拉契解法，用动态规划可以避免出现溢出情况
     * @param n
     * @return
     */
    public int numWay(int n)
    {
        int a=1;
        int b=2;
        int sum=0;
        for(int i=1;i<n;i++)
        {
            sum=(a+b)%1000000007;
            a=b;
            b=sum;

        }
        return a;
    }
}
