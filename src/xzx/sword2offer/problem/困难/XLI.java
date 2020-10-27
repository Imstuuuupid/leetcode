package xzx.sword2offer.problem.困难;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 题目：
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *  
 * <p>
 * 限制：
 * <p>
 * 最多会对 addNum、findMedia进行 50000 次调用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class XLI {
    /**
     * 神仙思路：
     * 大小顶堆，顶堆是个什么东西？
     * PriorityQueue<>()
     */
    Queue<Integer> low, high;

    /**
     * initialize your data structure here.
     */
    public XLI() {
        //比中位数小的值都放在这里，栈顶是最大的数  大顶堆
        low = new PriorityQueue<>(Collections.reverseOrder());
        //比中位数大的值都放在这里，栈顶是最小的数  小顶堆
        high = new PriorityQueue<>();

    }

    public void addNum(int num) {
        //这里没有特定的顺序，但是要和下面的查找中位数顺序保持一致
        if (low.size() != high.size()) {
            low.add(num);
            high.add(low.poll());
        } else {
            high.add(num);
            low.add(high.poll());

        }
    }

    public double findMedian() {
        if (low.size() != high.size()) {
            return low.peek();
        } else {
            return (high.peek() + low.peek()) / 2.0;
        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

