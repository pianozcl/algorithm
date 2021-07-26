package other.core_java.test_api;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/7/19  12:10 AM
 * @description:
 **/
public class TestHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        Integer[] integers = set.toArray(new Integer[2]);
        System.out.println(JSON.toJSONString(integers));
    }
}
