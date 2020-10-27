package xzx.sword2offer.problem.简单;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目：和为s的连续正整数序列
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LVII_II {
    /**
     * 思路：滑动窗口
     * <p>
     * 设置i,j
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 1;
        int sum = 0;
        ArrayList<int[]> res = new ArrayList<>();
        while (i <= target / 2) {
            if (sum < target) {
                sum += j++;
            } else if (sum > target) {
                sum -= i++;
            } else {
                int[] tmp = new int[j - i];
                for (int k = i; k < j; k++) {
                    tmp[k - i] = k;
                }
                res.add(tmp);
                sum -= i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * 双百思路，没看懂。
     * @param target
     * @return
     */
    public int[][] findContinuousSequence1(int target) {
        List<int[]> result = new ArrayList<>();
        int i = 1;
        while(target>0)
        {
            target -= i++;
            if(target>0 && target%i == 0)
            {
                int[] array = new int[i];
                for(int k = target/i, j = 0; k < target/i+i; k++,j++)
                {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }
}
