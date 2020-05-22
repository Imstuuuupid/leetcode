package xzx.剑指offer.题目.简单;

/**
 * 题目：
 * 圆圈中剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LXII {
    /**
     * 思路：
     * 这个题目是很著名的约瑟夫环问题，
     * 采用数学解法。
     *
     * 从最后一轮开始倒推剩下的最后一个数每一次的位置
     * 最后一次只剩下这个数，故位置为0
     * 上一次剩下2个数，删除第m个数是不变的条件
     * 所以上一轮这个数所在的位置为（now+m）%剩下的数
     * （res+m)%i
     *
     * 一直倒推，倒推到初始时n个数字时，就能得到结果数字的下标
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int res=0;
        for(int i=2;i<=n;i++)
        {
            res=(res+m)%i;
        }
        //数组从0开始，所以下标就是这个数
        return res;
    }
}
