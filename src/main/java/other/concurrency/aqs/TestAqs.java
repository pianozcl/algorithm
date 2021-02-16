package other.concurrency.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : chenliangzhou
 * create at:  2021/2/9  10:12 AM
 * @description:
 **/
public class TestAqs {
    static final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    print();
                }
            }).start();
        }
    }

    static void print() {
        lock.lock();
        try {
            System.out.println("同步代码块");
            Thread.sleep(1000 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
