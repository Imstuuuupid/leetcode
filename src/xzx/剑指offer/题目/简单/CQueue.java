package xzx.剑指offer.题目.简单;

import java.util.Stack;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 * 设计思路：
 *      1、一个栈A用来存储信息，另一个栈B用来删除信息
 *      2、A存储的顺序是相反的，所以在删除时将内容倒叙进入B
 *      3、当B里面不存在元素时，将A中的信息导入
 *      4、当B里面存在信息时，不用将A导入，因为在B里面顺序是正确的
 *      5、即只需要保持 添加 和 删除 顺序正确即可。
 *
 *      举个例子就是：                   删除         添加之后：
 *          队列： 头  12345   尾       2345         23456
 *
 *          A ： 底部  5     头          56          56
 *          B ： 底部  4321  头         432          432
 *
 *
 */
public class CQueue {


    private Stack<Integer> stacka=null;
    private Stack<Integer> stackb=null;


    public CQueue() {
        stacka=new Stack<>();
        stackb=new Stack<>();

    }

    /**
     * 添加A
     * @param value
     */
    public void appendTail(int value) {
        stacka.push(value);
    }

    /**
     * 删除 B
     * @return
     */
    public int deleteHead() {
        //B非空 就能出栈
        if(!stackb.empty())
        {
            return stackb.pop();
        }
        //此条件下 B为空，  看A是否为空，如果是则队列为空，否则倒序A进入B
        if(stacka.empty())
        {
            return -1;
        }
        //倒序
        while (!stacka.empty())
        {
            stackb.push(stacka.pop());
        }
        //能倒序则表示队列里面有元素，可以出栈
        return stackb.pop();
    }
}
