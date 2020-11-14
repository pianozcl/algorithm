package array;

import java.util.HashMap;

/**
 * @author : chenliangzhou
 * create at:  2020/9/30  5:05 PM
 * @description:
 **/
public class TwoSum {
    public static void main(String[] args) {
        int[] arr={3,2,4};
        int[] ints = twoSumByMap(arr, 6);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] twoSum (int[] numbers, int target) {
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j]==target){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSumByMap (int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                return new int[]{map.get(target-numbers[i]),i};
            }
            map.put(numbers[i],i);
        }
        return new int[]{};
    }
}
