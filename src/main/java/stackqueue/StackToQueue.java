package stackqueue;

import java.util.Stack;

/**
 * @author : chenliangzhou
 * create at:  2021/1/9  3:08 PM
 * @description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 **/
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.isEmpty() && stack1.isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.pop();
    }
}
