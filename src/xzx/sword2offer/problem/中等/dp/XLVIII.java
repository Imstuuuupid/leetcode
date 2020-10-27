package xzx.sword2offer.problem.中等.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：最长不含重复的子字符串
 * <p>
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * <p>
 * 提示：
 * <p>
 * s.length <= 40000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class XLVIII {
    /**
     * 思路：
     * 遍历，遍历的时候在包一个反遍历查重
     * temp表示当前最大连续个数
     * res表示历史最大连续个数
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int tmp = 0;
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while (i >= 0 && s.charAt(j) != s.charAt(i)) {
                i--;
            }
            //此时i跳出停在重复的地方，或者到了-1，
            // 那么如果tmp比这个区间小，表示这个子字符串没有断还在增大，所以+1
            // 但是如果tmp比这个区间打，表示子字符串断了，就要重新计数，j-i
            if (tmp < j - i) {
                tmp++;
            } else {
                tmp = j - i;
            }
            //这个时候要记录最大值
            res = Math.max(res, tmp);

        }
        return res;

    }

    /**
     * 对以上那个方法还能优化，因为是往后遍历查重的时候消耗了大量时间
     * 所以使用哈希表，哈希表的查找时间复杂度是O(1)
     * 还是动态规划，+哈希表
     * <p>
     * 思路还是不变的，就是细节优化一下
     *
     * 同样是查找重复字符的下标，用哈希表就比线性遍历要快
     * @param s
     * @return
     */
    public int betterInTime(String s) {
        int res = 0;
        int tmp = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            //如果这个字符已经存在了哈希表中，就取出它的下标，
            // 把重复字符下标赋值给i
            // 如果没有，那么i就回到开头了
            int i = map.getOrDefault(s.charAt(j), -1);
            map.put(s.charAt(j),j);
            if (tmp < j - i) {
                tmp++;
            } else {
                tmp = j - i;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}
