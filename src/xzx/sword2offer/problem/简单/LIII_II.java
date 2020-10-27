package xzx.sword2offer.problem.简单;

/**
 * 题目：0~n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LIII_II {
    /**
     * 思路：
     * 二分法
     * 缺失数字后，可以把数组分为左边（数字与下标相等）部分、右边（数字与下标不等）部分
     * 只需要找到右边起始的数字下标，即可得出缺失的数字
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int begin=0;
        int end=nums.length-1;
        while (begin<=end)
        {
            int mid=(begin+end)/2;
            if(nums[mid]==mid)
            {
                begin=mid+1;
            }else {
                end=mid-1;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        LIII_II x=new LIII_II();
        int[] nums={0,1,2,3,4,6,7,8,9};
        int res=x.missingNumber(nums);
        System.out.println(res);
    }
}
