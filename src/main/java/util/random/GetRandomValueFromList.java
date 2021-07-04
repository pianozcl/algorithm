package util.random;

import java.util.Arrays;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/6/29  7:05 PM
 * @description: 随机从List集合中获取元素
 **/
public class GetRandomValueFromList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c");

        for (int i = 0; i < 10; i++) {
            printRandomValueFromList(list);
        }



    }

    public static void printRandomValueFromList(List list) {
        int index = (int) (Math.random()* list.size());
        System.out.println(list.get(index));
    }
}
