package xzx.剑指offer.题目.简单;

/**
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 */

public class 斐波拉契 {


    /**
     * 这个解法会造成时间复杂度过高，所以提交失败，要用动态规划思想
     */
//    public static int fibb(int n)
//    {
//        if(n==0)
//        {
//            return 0;
//        }
//        else if(n==1)
//        {
//            return 1;
//        }
//        else
//        {
//            return fibb(n-1)+fibb(n-2)>1000000007?fibb(n-1)+fibb(n-2):fibb(n-1)+fibb(n-2)%1000000008;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println(1e9+7);
//        System.out.println("请输入一个整数（0-100）");
//        int a=sc.nextInt();
//        System.out.println(fibb(a));
//    }

    /**
     * 输入n=0时，要返回0，则只有a满足条件，故以a为返回基准
     * 直接对计算结果取模，可以保证不出现溢出
     * @param n
     * @return
     */
    public static int fiba(int n)
    {
        int a=0;
        int b=1;
        int sum=-1;

        for(int i=0;i<n;i++)
        {
            sum=(a+b)%1000000007;
            a=b;
            b=sum;

        }
        return a;

    }

    public static void main(String[] args) {
        int a=fiba(1);
        System.out.println(a);

    }
}
