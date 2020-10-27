package xzx.sword2offer.problem.简单;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 数组中出现超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 *  
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */
public class XXXIX {
    /**
     * 思路：
     * 设置一个数组，遍历 存储  判断
     * <p>
     * <p>
     * 最优解：
     * 摩尔投票，方法就是一对一抵消，剩下多的那一方
     * 具体实现方法就是，假设一个数为众数，值为+1，其余为-1，
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int value = map.get(num);
                if (value >= nums.length / 2) {
                    res = num;
                }
                map.put(num, ++value);
            } else {
                map.put(num, 1);
            }
        }
        return res;
    }

    public int better(int[] nums) {
        int count = 0;
        int major = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
            }
            if (major == num) {
                count++;
            }
            if (major != num) {
                major--;
            }
        }
        return major;
    }

}
