package other.jvm.reference;

import java.lang.ref.WeakReference;

/**
 * @author : chenliangzhou
 * create at:  2021/4/22  2:14 PM
 * @description: 弱引用，不管内存是否足够，只要发生gc就会被回收
 **/
public class WeakRef {
    public static void main(String[] args) {
        WeakReference<WeakRef> weakReference = new WeakReference<>(new WeakRef());
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());        //null
    }
}
