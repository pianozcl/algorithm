package other.concurrency;

import java.util.concurrent.locks.LockSupport;

/**
 * @author : chenliangzhou
 * create at:  2021/1/25  12:19 AM
 * @description:
 **/
public class TestPark {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("main");
                try {
                    testPark();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LockSupport.unpark(t1);


    }

    public static void testPark() {
        System.out.println("t1---1");
        LockSupport.park();
        System.out.println("t1---2");
    }
}
