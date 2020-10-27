package xzx.sword2offer.problem.简单;

import java.util.ArrayList;

/**
 * 题目：
 *      打印从1到最大的n位数
 */
public class XVII {
    /**
     * 使用
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        ArrayList<Integer> res=new ArrayList<>();
        int max=1;
        while (n!=0)
        {
            max*=10;
            n--;
        }
        for(int i=1;i<=max;i++)
        {
            res.add(i);
        }
        //列表转数组，这个要记住咯
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
