package other.concurrency;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : chenliangzhou
 * create at:  2021/2/13  8:44 PM
 * @description:    让一组线程等待至某个状态之后再全部同时执行
 **/
public class TestCyclicBarrier {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Writer());
        }
    }

    static class Writer implements Runnable {

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据");
            try {
                Thread.sleep(new Random().nextInt(3000));
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕");
                System.out.println("******************************************");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("所有线程写入完毕，线程" + Thread.currentThread().getName() + "正在执行其他任务");
        }
    }
}
