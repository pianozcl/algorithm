package other.jvm.reference;

import java.lang.ref.SoftReference;

/**
 * @author : chenliangzhou
 * create at:  2021/4/22  11:54 AM
 * @description: 软引用，内存不足才会回收
 **/
public class SoftRef {
    public static void main(String[] args) {

        //创建SoftReference包装SoftRef
        SoftReference<SoftRef> softReference = new SoftReference<SoftRef>(new SoftRef());

        System.out.println(softReference.get());
        System.gc();
        System.out.println(softReference.get());    //内存不足的时候才会回收，所以这里不会回收



        SoftReference<byte[]> softReference2 = new SoftReference<byte[]>(new byte[1024 * 1024 * 10]);
        System.out.println(softReference2.get());   //未回收
        System.gc();
        System.out.println(softReference2.get());    //未回收


        //-Xmx20M  分配10m的字节数组后，打印结果为null，说明软引用在内存不足的时候会回收
        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println(softReference2.get());   //null

    }
}
