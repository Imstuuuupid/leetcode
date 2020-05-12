package xzx.剑指offer.题目.简单;

/**
 * 题目：
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class XXI {
    /**
     * 憨憨思路：
     * 遍历交换
     *
     * 经典算法:
     *  头尾双指针、快慢指针
     *  本解法是头尾双指针
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<right)
        {
            if(nums[left]%2!=0)
            {
                left++;
                //跳过多余的操作
                continue;
            }
            if(nums[right]%2!=1)
            {
                right--;
                continue;
            }
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        return nums;
    }
}
