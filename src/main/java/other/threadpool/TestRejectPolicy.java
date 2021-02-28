package other.threadpool;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : chenliangzhou
 * create at:  2021/2/27  11:18 PM
 * @description: 测试线程池的拒绝策略
 **/
public class TestRejectPolicy {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        //pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy()); //丢弃任务并抛出RejectedExecutionException异常。
        //pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());   //丢弃任务，但是不抛出异常
        //pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy()); //丢弃队列最前面的任务，然后重新尝试执行任务
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());    //由调用线程处理该任务,例如main线程

        for (int i = 0; i < 130; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }


    }
}
