package xzx.codenothing.I.day2;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 * 在这种情况下，你会怎样改变代码？
 *
 * @author 谢子轩
 * @date 2023/04/15 10/08
 */
public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence is = new IsSubsequence();
        String s = "abc";
        String t = "ahbgdc";
        boolean subsequence = is.isSubsequence(s, t);
        System.out.println(subsequence);
    }

    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        if (s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(sIndex)) {
                sIndex++;
            }
            if (sIndex >= s.length()) {
                return true;
            }
        }
        return false;
    }

}
