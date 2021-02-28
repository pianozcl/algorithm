package other.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author : chenliangzhou
 * create at:  2021/2/28  1:02 AM
 * @description: 创建线程的几种方式
 **/
public class TestCreateThread {

    public static class ExtendThread extends Thread {
        @Override
        public void run() {
            System.out.println("extend thread");
        }
    }

    public static class ImplRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("impl runnable");
        }
    }

    public static class ImplCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("impl callable");
            Thread.sleep(1000);
            return Thread.currentThread().getName();
        }
    }

    public static void main(String[] args) throws Exception{
        ImplCallable implCallable = new ImplCallable();
        //FutureTask传入实现FutureTask的对象,异步获取执行结果
        FutureTask<String> futureTask = new FutureTask<>(implCallable);
        Thread thread = new Thread(futureTask, "有返回值的线程");
        thread.start();

        System.out.println(futureTask.get());

    }
}
