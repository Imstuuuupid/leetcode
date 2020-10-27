package xzx.sword2offer.problem.中等;

/**
 * 题目：
 *      机器人的运动范围
 *
 *
 *      地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 *      它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 *      例如，当k为18时，机器人能够进入方格 [35, 37] ，
 *      因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 */
public class XIII_movingCount {
    /**
     * 思路：
     *      封装一个求各位数和的函数
     *      用深度优先算法搜索右、下两个方向，
     *      递归考虑条件：
     *          （i<0   j<0    i>=m    j>=m      k< sum (i,j)  )
     *           这种条件下，递归函数返回0，除此之外返回1+向右递归+向下递归
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] flag=new boolean[m][n];
        return dfs(flag,0,0,k);
    }

    int dfs(boolean [][]flag,int i,int j,int k)
    {
        //条件错误，不计
        if(i<0||j<0||i>=flag.length||j>=flag[0].length||k<sum(i,j)||flag[i][j])
        {
            return 0;
        }
        flag[i][j]=true;
        //递归一次，计数一次，向下递归，向右递归
        return 1+dfs(flag,i+1,j,k)+dfs(flag,i,j+1,k);
    }


    int sum(int i, int j)
    {
        int sum=0;
        while (i!=0)
        {
            sum+=i%10;
            i=i/10;
        }
        while (j!=0)
        {
            sum+=j%10;
            j=j/10;
        }
        return sum;
    }

}
