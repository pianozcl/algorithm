package other.core_java.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author : chenliangzhou
 * create at:  2021/2/26  11:48 AM
 * @description:
 **/
public class TestCopyOnWrite {
    public static void main(String[] args) {

        //多线程同时读写会产生线程安全问题
        //ArrayList<Integer> list = new ArrayList<>();

        //不会产生线程安全问题
        //适用于多读少写场景，因为写的时候会拷贝新的数组
        //缺点：读的是旧的数组，实时性不高
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //因为整个add过程是加锁的，首先会复制一份数组，add完了之后会将引用指向新的数组
                    list.add(random.nextInt());
                }
            }).start();
        }

        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                }
            }).start();
        }
    }
}
