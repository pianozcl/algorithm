package other.core_java.hashcode_and_equals;

import java.util.*;

/**
 * @author : chenliangzhou
 * create at:  2021/2/5  1:57 PM
 * @description:
 **/
public class Test {
    int val;

    public Test(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }


    @Override
    public int hashCode() {
//        Random random = new Random();
//        return random.nextInt();
        return 1;
    }

    public static void main(String[] args) {
//        Test test = new Test(1);
//        Test test1 = new Test(2);
//        System.out.println(test.equals(test1));
//        System.out.println(test.hashCode());
//        System.out.println(test1.hashCode());
//
        String s = "123";
        String s1 = "123";
        String s2 = new String("123");
        System.out.println(s == s1);
        System.out.println(s == s2);
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
//        System.out.println(s1.hashCode() == s2.hashCode());
//        System.out.println(s1.hashCode() == s.hashCode());
//        System.out.println(s == s1);
//        System.out.println(s == s2);
//        Integer integer = new Integer(1);
//        Integer integer1 = new Integer(1);
//        System.out.println(integer.equals(integer1));
//        System.out.println(integer == integer1);
//
//        System.out.println(integer.hashCode());
//        System.out.println(integer1.hashCode());
//
//        System.out.println(s.hashCode());
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
//        HashMap<Object, Object> map = new HashMap<>();
//        for (int i = 0; i < 100; i++) {
//            map.put(new Test(i), new Test(i));
//        }
//        map.put(new Test(101), new Test(101));
//
//        for (int i = 0; i < 100; i++) {
//            map.put(UUID.randomUUID(), i);
//        }
//        System.out.println(map);
//
//        System.out.println(255 & -2047250035);
//        System.out.println(5 & 4);
//        System.out.println((int)(100 & 4));
//        System.out.println(100 % 3);
//        System.out.println(100 & 0);
//        System.out.println(100 % 5);
//
//        System.out.println((10 % 4) == (10 & 3));
//
//        System.out.println(5 % (-10));
//
//        System.out.println(255 & 2047250035);
//        System.out.println(256 % 2047250035);

//        HashSet objects = new HashSet<>();
//        objects.add(new Test(1));
//        objects.add(new Test(1));
//        System.out.println(objects.size());
        System.out.println(7 % (-3));


    }
}
