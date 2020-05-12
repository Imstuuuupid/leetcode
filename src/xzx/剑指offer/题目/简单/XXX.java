package xzx.剑指offer.题目.简单;

/**
 * 题目：
 * 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 */
public class XXX {
    private double minNum;
    private int top;
    private int p;
    private int []stack;

    public XXX() {
        //正无穷
        minNum=Double.POSITIVE_INFINITY;
        top=-1;
        stack=new int[20000];
    }

    public void push(int x) {
        stack[++top]=x;
        if(x<minNum)
        {
            minNum=x;
        }
    }

    public void pop() {
        System.out.println(stack[top--]);
    }

    public int top() {
        if(top>=0)
        {
            return stack[top];
        }
        return -1;
    }

    public int min() {
        return (int) minNum;
    }

    public static void main(String[] args) {
        XXX minStack=new XXX();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }
//
//    Stack<Integer> a,b;
//    public MinStack() {
//        a=new Stack<>();
//        b=new Stack<>();
//    }
//
//    public void push(int x) {
//        a.add(x);
//        if(b.empty()||b.peek()>=x)
//        {
//            b.add(x);
//        }
//
//    }
//
//    public void pop() {
//        if (a.pop().equals(b.peek()))
//        {
//            b.pop();
//        }
//    }
//
//    public int top() {
//        return a.peek();
//    }
//
//    public int min() {
//        return b.peek();
//    }
}
