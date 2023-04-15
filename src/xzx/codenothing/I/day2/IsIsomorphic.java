package xzx.codenothing.I.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * @author 谢子轩
 * @date 2023/04/13 12/08
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        IsIsomorphic i = new IsIsomorphic();
        boolean isomorphic = i.isIsomorphic(s, t) && i.isIsomorphic(t, s);
        System.out.println(isomorphic);
    }

    public boolean isIsomorphic(String s, String t) {
        return validate(s, t) && validate(t, s);
    }

    private boolean validate(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map.containsKey(sChar)) {
                if (!map.get(sChar).equals(tChar)) {
                    return false;
                }
            } else {
                map.put(sChar, tChar);
            }
        }
        return true;
    }
}
