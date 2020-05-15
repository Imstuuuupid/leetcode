package xzx.剑指offer.题目.简单;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目：
 * 滑动窗口的最大值
 *
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LIX {
    /**
     * 思路：
     * 歪门邪道之数组切割排序取最后
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int begin=0;
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=k-1;i<=nums.length-1;i++)
        {
            int []temp=Arrays.copyOfRange(nums,begin,i+1);
            Arrays.sort(temp);
            System.out.println(temp);
            res.add(temp[k-1]);
            begin++;
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int []nums = {1,3,-1,-3,5,3,6,7};
        LIX s=new LIX();
        for(int i:s.maxSlidingWindow(nums,3))
        {
            System.out.println(i);
        }
    }
}
