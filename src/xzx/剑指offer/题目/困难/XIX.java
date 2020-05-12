package xzx.剑指offer.题目.困难;

/**
 * 题目：
 * 正则表达式匹配
 * <p>
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
public class XIX {
    /**
     * 思路：
     * 采用递归，则只需要考虑单个字符匹配情况，核心是substring(1)带入原函数
     * <p>
     * 空串+空正则  true
     * 空串+非空正则  判断正则是否是(x*y*z*)形式 ： 是，true  否，false
     * 非空串+空正则  false
     * <p>
     * 正则串情况分析：
     * 1、普通字符，直接比较就好了
     * 2、 . 可以直接匹配，然后跳过
     * 3、 *  这个符号在考虑的时候需要结合前一个字母，故对正则串采用双指针
     * 细分：
     * ①、当z!=*时，x==y||y=='.'，直接进入递归
     * ②、当z==*时，判断y与x，
     * 如果不等，直接略过*，即B.substring(2)
     * 如果相等，（这里妙啊），A.substring(1)、B不动
     * 或者A、B.substring(2)
     * 就算有*，也有前面字符当成0个的处理方式；
     * 而A则是往前移动一位
     * <p>
     * <p>
     * <p>
     * 程序设计：
     * x->A.charAt(0)
     * y->B.charAt(0)
     * z->B.charAt(1)
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (s.length() == 0) {
            if (p.length() % 2 != 0) {
                return false;
            }
            int i = 1;
            while (i < p.length()) {
                if (p.charAt(i) != '*') {
                    return false;
                }
                i += 2;
            }
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        char x = s.charAt(0);
        char y = p.charAt(0);
        char z ='a';
        if(p.length()>1)
        {
            z=p.charAt(1);
        }
        if (z != '*') {
            // 如果该位字符一样，或是正则串该位是 '.',也就是能匹配任意字符，就可以往后走
            if (x == y || y == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                // 否则不匹配
                return false;
            }
        } else {
            // 如果该位字符一样，或是正则串该位是 '.'，和dp一样，有看和不看两种情况
            if (x == y || y == '.') {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                // 不一样，那么正则串这两位就废了，直接往后走
                return isMatch(s, p.substring(2));
            }
        }
    }

    public static void main(String[] args) {
        String s="mississippi";
        String p="mis*is*p*.";
        System.out.println(isMatch(s,p));
    }
}
