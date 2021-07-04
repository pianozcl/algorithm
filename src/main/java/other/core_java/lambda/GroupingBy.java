package other.core_java.lambda;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import other.core_java.lambda.vo.Fruit;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : chenliangzhou
 * create at:  2021/7/2  11:02 PM
 * @description:
 **/
public class GroupingBy {
    public static void main(String[] args) {
        List<Fruit> fruitList = Lists.newArrayList(new Fruit("apple", 6),
                new Fruit("apple", 6),
                new Fruit("banana", 7), new Fruit("banana", 7),
                new Fruit("banana", 7), new Fruit("grape",8));

        Map<String, Long> collect = fruitList.stream().map(Fruit::getName).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(JSON.toJSONString(collect));  //{"banana":3,"apple":2,"grape":1}

        Map<String, List<Fruit>> collect1 = fruitList.stream().collect(Collectors.groupingBy(Fruit::getName));
        System.out.println(JSON.toJSONString(collect1));

    }
}
