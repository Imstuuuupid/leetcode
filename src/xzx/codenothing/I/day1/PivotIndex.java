package xzx.codenothing.I.day1;

/**
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。
 * 这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 * https://leetcode.cn/problems/find-pivot-index/?envType=study-plan&id=leetcode_75_level_1&plan=leetcode_75&plan_progress=x51mvfi6%3FenvType%3Dstudy-plan&id=leetcode_75_level_1&plan=leetcode_75&plan_progress=x51mvfi6
 *
 * @author 谢子轩
 * @date 2023/04/13 11/55
 */
public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {-1, -1, 0, 1, 1, 0};
        PivotIndex p = new PivotIndex();
        int i = p.pivotIndex(nums);
        System.out.println(i);
    }

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int leftSum = 0;
        int rightSum = total - nums[0];
        if (leftSum == rightSum) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum = rightSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
