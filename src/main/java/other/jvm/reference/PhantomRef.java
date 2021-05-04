package other.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : chenliangzhou
 * create at:  2021/4/22  2:24 PM
 * @description: 虚引用
 **/
public class PhantomRef {
    public static void main(String[] args) {
        //比如传入一个队列，当GC准备回收一个对象，发现它还有虚引用，会把这个虚引用添加到ReferenceQueue队列
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference<byte[]> phantomReference = new PhantomReference<byte[]>(new byte[1], queue);
        System.out.println(phantomReference.get()); //null

        List<byte[]> bytes = new ArrayList<>();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bytes.add(new byte[1024 * 1024]);
            }
            System.gc();
        }).start();

        new Thread(() -> {
            while (true) {
                Reference poll = queue.poll();
                if (poll != null) {
                    System.out.println("虚引用被回收");
                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        scanner.hasNext();
    }
}
