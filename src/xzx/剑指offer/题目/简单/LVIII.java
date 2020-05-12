package xzx.剑指offer.题目.简单;

/**
 * 题目：
 * 翻转单词顺序
 * <p>
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LVIII {
    /**
     * 思路：
     * <p>
     * 还思路个屁啊！！！！
     * 少废话看代码，基础功不扎实就是这样
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        //按 空格 分割单词，去掉收尾空格
        String[] strings = s.trim().split(" ");
        for (int i = strings.length- 1; i >= 0; i--) {
            if ("".equals(strings[i])) {
                continue;
            }
            res.append(strings[i] + " ");
        }
        return res.toString().trim();


    }
}
