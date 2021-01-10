package stackqueue;

import java.util.Stack;

/**
 * @author : chenliangzhou
 * create at:  2021/1/9  4:00 PM
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 *
 * 思路：第一个栈正常压栈出栈         stack1  栈底 5，3，7，4，2 栈顶
 * 第二个栈，维护递减当栈元素，例如    stack2  栈底 5，3，2 栈顶
 **/
public class StackWithMinMethod {
    Stack<Integer> a = new Stack();
    Stack<Integer> b = new Stack();

    public void push(int node) {
        a.push(node);
        if (b.isEmpty() || a.peek() <= b.peek()) {
            b.push(node);
        }
    }

    public void pop() {
        if (!b.isEmpty() && a.pop() <= b.peek()) {
            b.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }
}
