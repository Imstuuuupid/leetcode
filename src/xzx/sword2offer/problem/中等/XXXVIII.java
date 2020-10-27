package xzx.sword2offer.problem.中等;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：
 * 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 *  
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class XXXVIII {

    /**
     * 思路：
     * 枝剪+dfs+回溯
     * <p>
     * 具体实现步骤还未领悟，先按照感觉来写把
     *
     * @param s
     * @return
     */
    List<String> res = new LinkedList<>();
    char []c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);

    }

    public void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
        }
        //用来存放字符，可以判断是否重复
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length ; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i,x);
            dfs(x+1);
            swap(i,x);
        }
    }

    public void swap(int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    public static void main(String[] args) {
        XXXVIII x=new XXXVIII();
        System.out.println(x.permutation("abc"));

    }
}
