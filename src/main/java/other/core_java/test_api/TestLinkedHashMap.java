package other.core_java.test_api;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author : chenliangzhou
 * create at:  2021/7/27  9:26 AM
 * @description:
 **/
public class TestLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(100, 100);
        map.put(50, 50);

        for (Integer integer : map.keySet()) {
            System.out.println(integer);        //遍历顺序和插入顺序一致
        }
        


        HashMap<Integer, Integer> map1 = new HashMap();
        map1.put(1, 1);
        map1.put(2, 2);
        map1.put(3, 3);
        map1.put(100, 100);
        map1.put(50, 50);
        for (Integer integer : map1.keySet()) {
            System.out.println(integer);    //不能保证遍历顺序和插入顺序一致
        }
    }
}
