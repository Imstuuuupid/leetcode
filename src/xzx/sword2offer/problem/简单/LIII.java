package xzx.sword2offer.problem.简单;

import java.util.HashMap;

/**
 * 题目：
 * 在排序数组中查找数字
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LIII {
    /**
     * 思路：
     * 没看见排序数组，所以用了map，耗时巨多。
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        if(nums.length==0)
        {
            return 0;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
        {
            if(map.containsKey(i))
            {
                int count=map.get(i)+1;
                map.put(i,count);
            }else {
                map.put(i,1);
            }
        }
        return map.getOrDefault(target, 0);
    }

    /**
     * 思路：
     * 排序数组，考虑使用二分法
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        //先搜索左边界
        while (i<=j)
        {
            int m=(i+j)/2;
            if(nums[m]<=target)
            {
                i=m+1;
            }else {
                j=m-1;
            }
        }
        int right=j;
        i=0;
        //然后搜索右边界
        while (i<=j)
        {
            int m=(i+j)/2;
            if(nums[m]>=target)
            {
                j=m-1;
            }else {
                i=m+1;
            }
        }
        return right-j-1;
    }
}
