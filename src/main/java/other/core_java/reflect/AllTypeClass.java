package other.core_java.reflect;

import java.lang.annotation.ElementType;

/**
 * @author : chenliangzhou
 * create at:  2021/3/28  11:52 AM
 * @description: 所有类型class
 **/
public class AllTypeClass {
    public static void main(String[] args) {
        Class<Object> c1 = Object.class;
        Class<int[][]> c2 = int[][].class;
        Class<Override> c3 = Override.class;
        Class<ElementType> c4 = ElementType.class;
        Class<Void> c5 = void.class;
        Class<Class> c6 = Class.class;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);


        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.hashCode());//不同
        System.out.println(b.hashCode());

        System.out.println(a.getClass().hashCode());//相同，印证Class类只存在一份
        System.out.println(b.getClass().hashCode());
    }
}