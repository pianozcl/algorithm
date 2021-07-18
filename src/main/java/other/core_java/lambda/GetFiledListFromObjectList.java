package other.core_java.lambda;

import com.alibaba.fastjson.JSON;
import other.core_java.lambda.vo.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : chenliangzhou
 * create at:  2021/7/5  4:19 PM
 * @description: 提取出list对象中的一个属性
 **/
public class GetFiledListFromObjectList {
    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("111",1));
        list.add(new Fruit("222",1));
        list.add(new Fruit("133311",1));

        List<String> strings = list.stream().map(Fruit::getName).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(strings));
    }
}
