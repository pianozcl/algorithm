package stackqueue.basic;

/**
 * @author : chenliangzhou
 * create at:  2021/3/21  2:49 PM
 * @description: 基于数组的队列
 **/
public class ArrayQueue {
    private String[] items;
    private int len = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int len) {
        items = new String[len];
        this.len = len;
    }

    public boolean enqueue(String item) {
        if (tail == len) {
            if (head == 0) {
                return false;
            }

            //数据迁移。假如长度为10的队列，下标0 - 9。head = 5，tail = 9，此时无法再继续添加元素
            //但是 下标0 - 4并没有利用起来。需要对5 - 9对数据进行迁移，迁移到0 - 4
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            //迁移完成，重新更新head和tail指针
            tail -= head;
            head = 0;
        }
        items[tail++] = item;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String s = items[head++];
        return s;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(Integer.toString(i));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(arrayQueue.dequeue());
        }
    }
}
