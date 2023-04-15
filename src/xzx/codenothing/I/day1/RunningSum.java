package xzx.codenothing.I.day1;

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * <p>
 * 请返回 nums 的动态和。
 * https://leetcode.cn/problems/running-sum-of-1d-array/?envType=study-plan&id=leetcode_75_level_1&plan=leetcode_75&plan_progress=x51mvfi6
 *
 * @author 谢子轩
 * @date 2023/04/13 11/52
 */
public class RunningSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        RunningSum r = new RunningSum();
        int[] ints = r.runningSum(nums);
    }

    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}
