package other.threadpool;

import java.util.concurrent.*;

/**
 * @author : chenliangzhou
 * create at:  2021/7/11  12:40 PM
 * @description:
 **/
public class ThreadPoolSubmit {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));

        Future<String> submit = threadPoolExecutor.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                int i = 0;
                while (true) {
                    //异步调用远程接口，如果调用成功则跳出循环
                    Thread.sleep(1000);
                    String remote = remote(i++);
                    if ("success".equals(remote)) {
                        break;
                    }

                }
                return "thread done";
            }
        });
        System.out.println("hahaha");
        System.out.println(submit.get());

    }

    /**
     * 模拟远程调用
     * @return
     */
    public static String remote(int i) {
        if (i == 5) {
            return "success";
        }
        return "faild";
    }
}
