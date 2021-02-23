package other.producer_and_consumer;

/**
 * @author : chenliangzhou
 * create at:  2021/1/17  3:17 PM
 * @description:
 **/
public class Test1 {
    public Integer count = 0;
    public static final int FULL = 10;
    public String lock = "lock";

    class Producer implements Runnable {
        @Override
        public void run(){
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while (count == FULL) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "生产者阻塞count = " + count);
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+ "生产--------目前有" + count);
                    lock.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run(){
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while (count == 0) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "消费者阻塞count = " + count);
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费--------目前有" + count);
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        new Thread(test.new Producer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Producer()).start();



        new Thread(test.new Consumer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Consumer()).start();

    }
}
