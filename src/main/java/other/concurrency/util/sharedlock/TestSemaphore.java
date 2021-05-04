package other.concurrency.util.sharedlock;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author : chenliangzhou
 * create at:  2021/2/13  8:18 PM
 * @description: 信号量
 * 1. 必须使用acquire方法获得许可，如果许可数量为0，该线程则一直阻塞，直到有可用许可
 * 2. 默认情况下使用非公平策略
 * 应用场景：例如限制数据库连接数
 **/
public class TestSemaphore {
    private static final int COUNT = 40;
    private static Executor executor = Executors.newFixedThreadPool(COUNT);
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < COUNT; i++) {
            executor.execute(new Task());
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(5000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
