package other.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : chenliangzhou
 * create at:  2021/1/24  11:55 PM
 * @description:
 **/
public class TestReentrantLock {
    static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                testSleep();
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                testSleep();
            }
        };

        thread1.start();
        thread2.start();
    }

    public static void testSleep() {
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
