package xzx.sword2offer.problem.中等;

import java.util.Arrays;

/**
 * 题目：
 * 把数组排成最小的数
 * <p>
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *  
 * <p>
 * 提示:
 * <p>
 * 0 < nums.length <= 100
 * 说明:
 * <p>
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class XLV {
    /**
     * 思路：
     * 定义大小顺序，x+y>y+x  =>  x>y
     * 对这个数组排序
     * 首先转换成string
     * 然后compare
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(res, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder result = new StringBuilder();
        for (String s : res) {

            result.append(s);
        }
        return result.toString();



    }


}