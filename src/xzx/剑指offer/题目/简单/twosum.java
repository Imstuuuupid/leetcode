package xzx.剑指offer.题目.简单;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数，求数组中满足和与其相等的两数下标
 *
 * 思路：遍历数组，用目标数减去遍历数，如果map中不存在key值与结果相等，就放入，如果有，取出下标。
 */
public class twosum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                int index1=map.get(target-nums[i]);
                int index2=i;
                return new int[]{index1,index2};
            }
                map.put(nums[i],i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
