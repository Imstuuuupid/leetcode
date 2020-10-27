package xzx.sword2offer.problem.中等;

/**
 * 题目：
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 */
public class XX_isNumber {
    /**
     * 思路：
     * 用stringbuffer扫描字符串，
     * 用三个判别符   numSeen    dotSeen    eSeen
     * 遇到数字 numSeen true
     * 遇到点  dotSeen为true，如果前面出现了"."：dotSeen=true,"e":eSeen=true;就返回false
     * 遇到e   eSeen=true,如果前面没有数字：numSeen=false,出现了"e":eSeen=true;返回false
     * 遇到e以后要把numSeen置为false，保证e后面是数字
     * 遇到"+"/"-"： 这些符号要出现在开头或者e后面才是正确位置，否则返回false
     * 其他情况  也是返回false
     * <p>
     * <p>
     * 不能在for循环里面用迭代器，因为不能取到上一个和下一个元素
     *
     * @param s
     * @return numSeen
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        //trim()函数去除首位的空格符等符号
        char[] item = s.trim().toCharArray();
        for (int i = 0; i < item.length; i++)
        {
            //数字
            if (item[i] >= '0' && item[i] <= '9')
            {
                numSeen = true;
            }
            //.之前不能出现.也不能出现e
            else if (item[i] == '.')
            {
                if (dotSeen || eSeen)
                {
                    return false;
                }
                dotSeen = true;
            }
            //e前面必须有数字，也不能出现e
            else if (item[i] == 'e' || item[i] == 'E')
            {
                if (!numSeen || eSeen)
                {
                    return false;
                }
                eSeen = true;
                numSeen = false;
            }
            //+和- 必须出现在首位或者e后面的第一位
            else if (item[i] == '+' || item[i] == '-')
            {
                if (i != 0 && item[i - 1] != 'e' && item[i - 1] != 'E')
                {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen;
    }
}
