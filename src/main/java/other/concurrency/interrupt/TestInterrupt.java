package other.concurrency.interrupt;

/**
 * @author : chenliangzhou
 * create at:  2021/2/16  11:56 AM
 * @description:
 **/
public class TestInterrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread.interrupt();
    }
}
