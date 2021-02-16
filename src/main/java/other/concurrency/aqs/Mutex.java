package other.concurrency.aqs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author : chenliangzhou
 * create at:  2021/2/9  5:54 PM
 * @description: 自定义同步组件
 **/
public class Mutex implements Lock {
    private static class Sync extends AbstractQueuedSynchronizer {

        // Reports whether in locked state
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // Acquires the lock if state is zero
        @Override
        public boolean tryAcquire(int acquires) {
            assert acquires == 1; // Otherwise unused
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // Releases the lock by setting state to zero
        @Override
        protected boolean tryRelease(int releases) {
            assert releases == 1; // Otherwise unused
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // Provides a Condition
        Condition newCondition() { return new ConditionObject(); }

        // Deserializes properly
        private void readObject(ObjectInputStream s)
                throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0); // reset to unlocked state
        }
    }

    // The sync object does all the hard work. We just forward to it.
    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    static int num = 0;
    static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) throws InterruptedException {
        //syncTest();       //通过自定义同步组件加锁，100个线程执行完毕，num结果为10000000
        nonSyncTest();      //不经过加锁，100个线程执行完毕，结果不确定
    }

    static void nonSyncTest() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        num++;
                    }

                    //通过countDownLatch，等待100个子线程执行完毕，再执行主线程打印num
                    countDownLatch.countDown();
                }
            }).start();
        }

        //打印count，此刻不确定
        System.out.println(countDownLatch.getCount());
        countDownLatch.await();

        //打印count，此刻为0
        System.out.println(countDownLatch.getCount());
        System.out.println(num);
    }


    static void syncTest() throws InterruptedException {
        Mutex mutex = new Mutex();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        mutex.lock();
                        num++;
                        mutex.unlock();
                    }

                    //通过countDownLatch，等待100个子线程执行完毕，再执行主线程打印num
                    countDownLatch.countDown();
                }
            }).start();
        }

        //打印count，此刻不确定
        System.out.println(countDownLatch.getCount());
        countDownLatch.await();

        //打印count
        System.out.println(countDownLatch.getCount());
        System.out.println(num);
    }

}
