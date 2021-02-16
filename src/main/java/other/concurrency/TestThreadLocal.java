package other.concurrency;

/**
 * @author : chenliangzhou
 * create at:  2021/2/15  1:04 PM
 * @description:
 **/
public class TestThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());  //1
        }).start();

        //第二个线程改变threadLocal值，并不会影响第一个线程打印值，因为threadlocal是线程私有的
        new Thread(() -> {
            threadLocal.set(2);
        }).start();
    }
}
