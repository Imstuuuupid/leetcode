package xzx.sword2offer.problem.中等;

import java.util.Arrays;

/**
 * 题目：数组中数字出现的次数
 * <p>
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LVI_II {
    /**
     * 思路：
     * 先排序，然后遍历一次
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        //这个数字可能出现在首位，首先检查这种情况,因为其他数字出现三次，所以只需要判断0、1两位。
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[len - 1] != nums[len - 2]) {
            return nums[len - 1];
        }
        for (int i = 1; i < len; i++) {
            if ((nums[i] != nums[i - 1]) && (nums[i] != nums[i + 1])) {
                return nums[i];
            }
        }
        return 0;

    }
}
