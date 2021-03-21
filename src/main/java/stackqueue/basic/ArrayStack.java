package stackqueue.basic;

import java.util.UUID;

/**
 * @author : chenliangzhou
 * create at:  2021/3/21  11:46 AM
 * @description: 数组栈
 **/
public class ArrayStack {
    private String[] items;
    private int count; //元素个数
    private int len; //栈深度


    public ArrayStack(int len) {
        this.items = new String[len];
        this.count = 0;
        this.len = len;
    }

    public boolean push(String item) {
        if (count == len) {
            return false;
        }

        items[count++] = item;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String temp = items[--count];
        return temp;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        for (int i = 0; i < 10; i++) {
            arrayStack.push(Integer.toString(i));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arrayStack.pop());
        }

    }
}
