package other.jvm.reference;

/**
 * @author : chenliangzhou
 * create at:  2021/4/22  11:46 AM
 * @description: 强引用
 **/
public class StrongRef {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("被回收了");
    }

    public static void main(String[] args) {
        StrongRef strongRef = new StrongRef();
        strongRef = null;   //赋null值才会调用finalize方法
        System.gc();
    }
}
