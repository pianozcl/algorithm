package other.core_java.collections;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author : chenliangzhou
 * create at:  2021/3/5  8:30 PM
 * @description:
 **/
public class TestArrayList {
    public static void main(String[] args) {
        //可以添加空值
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(100000000);

        String s = UUID.randomUUID().toString();
        //动态扩容
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            list1.add(s);
        }
        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1));


        long t3 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            list2.add(s);
        }
        long t4 = System.currentTimeMillis();
        System.out.println((t4 - t3));

    }
}
