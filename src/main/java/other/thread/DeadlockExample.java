package other.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : chenliangzhou
 * create at:  2021/1/17  5:16 PM
 * @description:
 **/
public class DeadlockExample {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        DeadlockExample deadlock = new DeadlockExample();
        new Thread(deadlock::operation1, "T1").start();
        new Thread(deadlock::operation2, "T2").start();
    }

    public void operation1() {
        lock1.lock();
        System.out.println("lock1 acquired, waiting to acquire lock2.");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1 request lock2");
        lock2.lock();

        System.out.println("t1 request lock2 successful");
        lock1.unlock();
        lock2.unlock();
    }

    public void operation2() {
        lock2.lock();
        System.out.println("lock2 acquired, waiting to acquire lock1.");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t2 request lock1");
        lock1.lock();
        System.out.println("t2 request lock1 successful");
        lock1.unlock();
        lock2.unlock();
    }
}
