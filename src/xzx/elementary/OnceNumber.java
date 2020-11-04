package xzx.elementary;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Author: xzx
 * @Date: 2020/11/1 8:13 上午
 **/
public class OnceNumber {
    /**
     * 异或解法：
     * 异或运算满足交换律，
     * a^b^a=a^a^b=b,因此ans相当于nums[0]^nums[1]^nums[2]^nums[3]^nums[4].....
     * 然后再根据交换律把相等的合并到一块儿进行异或（结果为0），
     * 然后再与只出现过一次的元素进行异或，
     * 这样最后的结果就是，只出现过一次的元素（0^任意值=任意值）
     * @Author: xzx
     * @Date: 2020/11/1 8:15 上午
     * @Param: [nums]
     * @Return: int
     **/
    public int singleNumber(int[] nums) {
        int ans = 0 ;
        for(int i : nums) {
            ans = ans ^ i;
        }
        return ans;
    }
}
