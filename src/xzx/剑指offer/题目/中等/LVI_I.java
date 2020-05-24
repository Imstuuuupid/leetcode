package xzx.剑指offer.题目.中等;

/**
 * 题目：数组中数字出现的次数
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LVI_I {
    /**
     * 思路：
     * 异或规则：0^p=p   a^b=b^a   (a^b)^c=a^(b^c)
     * 通过异或所有数字得到一个结果，
     * 找到这个结果中位为1的数，表示要求的两个数在此位不相等，
     * 根据此位拆分数组为两部分，分别异或得到两个数字
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum^=i;
        }
        int digits=1;
        while ((digits&sum)==0)
        {
            digits<<=1;
        }
        int[] res=new int[2];
        for(int num:nums)
        {
            if((num&digits)==0)
            {
                res[0]^=num;
            }else {
                res[1]^=num;
            }
        }
        return res;
    }
}
