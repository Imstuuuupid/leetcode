package xzx.sword2offer.problem.简单;

/**
 * 题目：
 * 连续子数组的最大和
 *
 * 输入一个整型数组，数组里有正数也有负数。
 * 数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */
public class XLII {
    /**
     * 一道很经典的算法，
     * 采用dp算法
     *
     * 思路：
     * 当数组前一个小于0，与当前相加做负贡献，不加
     * 大于0，相加，然后替换当前值，即为当前连续子数组最大和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]>=0)
            {
                nums[i]+=nums[i-1];
            }
            res=Math.max(res,nums[i]);
        }
        return res;
    }
}
