package other.core_java.collections;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : chenliangzhou
 * create at:  2021/2/26  11:56 PM
 * @description:
 **/
public class TestConcurrentHashMap {
    public static void main(String[] args) throws Exception{
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        //HashMap<String, String> map = new HashMap<>();
        Random random = new Random();

//        for (int i = 0; i < 100; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < 100; i++) {
//                        synchronized (random) {
//                            map.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
//                        }
//                    }
//                }
//            }).start();
//        }

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        map.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
                    }
                }
            }).start();
        }

        Thread.sleep(5000);
        System.out.println(map.size());
    }
}
