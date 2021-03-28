package stackqueue.basic;

/**
 * @author : chenliangzhou
 * create at:  2021/3/21  3:27 PM
 * @description: 循环队列
 * 避免数据搬迁开销
 **/
public class CircularQueue {
    private String[] items;
    private int len = 0;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int len) {
        this.items = new String[len];
        this.len = len;
    }

    public boolean enqueue(String item) {
        //循环队列满的条件
        if ((tail + 1) % len == head) {
            return false;
        }

        items[tail] = item;

        //因为是循环队列，假如len = 8; 此刻tail = 7也就是第8个元素，对len取余后为0。因此到数组到最后一个元素后又回到第一个元素，永远不会越界
        tail = (tail + 1) % len;
        return true;
    }

    public String dequeue() {
        //队列为空
        if (head == tail) {
            return null;
        }

        String temp = items[head];
        head = (head + 1) % len;
        return temp;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(10);
        for (int i = 0; i < 10; i++) {
            circularQueue.enqueue(Integer.toString(i));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(circularQueue.dequeue());
        }
    }
}
