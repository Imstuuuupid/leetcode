package xzx.剑指offer.题目.简单;

/**
 * 替换空格：
 *      请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class ReplaceSpace {
    /**
     * 思路：
     *      1、遍历，判断是不是空格，是就替换
     *      2、使用函数
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        s.replace(" ","%20");
        return s;

    }

    /**
     * 用StringBuffer解决  学到了新的方法
     * @param s
     * @return
     */
    public String replaceSpaceSecond(String s)
    {
        StringBuffer sb=new StringBuffer();
        for(Character a:s.toCharArray())
        {
            //char类型用单引号
            if(a==' ')
            {
                sb.append("%20");
            }
            else
            {
                sb.append(a);
            }
        }
        return sb.toString();
    }
}
