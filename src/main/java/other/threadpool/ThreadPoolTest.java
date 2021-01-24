package other.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author : chenliangzhou
 * create at:  2021/1/17  6:46 PM
 * @description:
 **/
public class ThreadPoolTest {
    public static void main(String[] args) throws TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        });
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        });
//        Integer integer = null;
//        Future<Integer> future = executorService.submit(() -> {
//
//
//            Thread.sleep(100);
//            return 1;});
//        try {
//            integer = future.get(1, TimeUnit.SECONDS);
//
//        } catch (InterruptedException e) {
//
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println(integer);
//            executorService.shutdown();
//        }
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        Executors.newFixedThreadPool(5);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3");
            }
        }, 3, TimeUnit.SECONDS);

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), namedThreadFactory);
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

    }
}
