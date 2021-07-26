package other.core_java.test_api;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * @author : chenliangzhou
 * create at:  2021/7/19  1:25 PM
 * @description:
 **/
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);

        Integer[] integers = list.toArray(new Integer[list.size()]);
        System.out.println(JSON.toJSONString(integers));
    }
}
