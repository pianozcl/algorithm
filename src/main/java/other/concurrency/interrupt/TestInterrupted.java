package other.concurrency.interrupt;

/**
 * @author : chenliangzhou
 * create at:  2021/2/16  11:58 AM
 * @description:
 **/
public class TestInterrupted {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("while...");
            }
            System.out.println("thread end");
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
