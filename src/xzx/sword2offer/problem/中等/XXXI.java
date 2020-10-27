package xzx.sword2offer.problem.中等;

import java.util.Stack;

/**
 * 题目：
 * 栈的压入、弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class XXXI {
    /**
     * 思路：
     * 很简单的一道题，不要想复杂了
     * 按照给定的序列压入，压入之前判断栈顶元素与弹出序列的当前元素是否相等
     * 不相等就压入、相等就出栈
     *
     * 题目要求，给定的压栈序列里面没有重复的数字，所以可以用迭代器遍历
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
