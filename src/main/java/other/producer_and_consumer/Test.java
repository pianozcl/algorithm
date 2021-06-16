package other.producer_and_consumer;

/**
 * @author : chenliangzhou
 * create at:  2021/1/17  3:05 PM
 * @description: 生产者消费者
 **/
public class Test {
    private static int count = 0;
    private static final Integer FULL = 10;
    private static String LOCK = "lock";

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test.new Producer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Producer()).start();

        new Thread(test.new Consumer()).start();
    }

}
