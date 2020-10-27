package xzx.sword2offer.problem.简单;

import java.util.HashMap;

/**
 * 题目：
 * 第一个只出现一次的字符
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L {
    /**
     * 思路：
     *
     * 本题就是哈希表的考察
     *
     * 数组比哈希表快的原因，散列表每次需要计算哈希值，而数组没有这个问题
     * ASCII码只有256个，所以数组大小设为256
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        int []count=new int[256];
        char []c=s.toCharArray();
        for(char ch:c)
        {
            count[ch]++;
        }
        for(char ch:c)
        {
            if(count[ch]==1)
            {
                return ch;
            }
        }
        return ' ';
    }

    public char firstUniqChar1(String s)
    {
        HashMap<Character,Boolean> map=new HashMap<>();
        for(char c:s.toCharArray())
        {
            map.put(c,!map.containsKey(c));
        }
        for(char c:s.toCharArray())
        {
            if(map.get(c))
            {
                return c;
            }
        }
        return ' ';
    }
}
