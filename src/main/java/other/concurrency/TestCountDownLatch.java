package other.concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : chenliangzhou
 * create at:  2021/2/13  9:09 PM
 * @description: 某个线程等待其他线程执行到某个状态，再继续执行
 **/
public class TestCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(new Random().nextInt(3000));
                        System.out.println("线程" + Thread.currentThread().getName() + "执行完毕" + "count = " + countDownLatch.getCount());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
        }

        System.out.println("正在等待线程执行完毕");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程已经执行完毕");
    }
}
