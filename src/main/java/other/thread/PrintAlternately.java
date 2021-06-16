package other.thread;

/**
 * @author : chenliangzhou
 * create at:  2021/6/7  1:20 PM
 * @description: 两个线程交替打印1-100
 **/
public class PrintAlternately {
    public static void main(String[] args) {
        new Thread(new Printer(), "偶数线程").start();
        new Thread(new Printer(), "奇数线程").start();
    }

    private static int count = 0;
    private static String lock = "lock";

    static class Printer implements Runnable {

        @Override
        public void run() {
            while (count <= 2000) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "print: " + count++);

                    lock.notify();

                    if (count <= 2000) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
