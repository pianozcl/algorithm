package binarytree;

/**
 * @author : chenliangzhou
 * create at:  2021/1/6  1:27 PM
 * @description: 返回第一个数组中重复的数字
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中第一个重复的数字
 * 如果数组中有重复的数字，函数返回true，否则返回false。
 * 如果数组中有重复的数字，把重复的数字放到参数duplication[0]中
 * <p>
 * 例如 {2,3,1,0,2,5,3} 返回2
 **/
public class DuplicateNumberInArray {


    /*
    思路：置换法，把每个元素，放到它应该在的位置，例如
    第一次
    2,3,1,0,2,5,3
    1,3,2,0,2,5,3
    第二次
    1，0，2，3，2，5，3
    ....
    第五次
    遍历到下标4，元素2，发现2相同，返回

     */

    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        //循环 i前面的元素，已经放到正确的位置
        for (int i = 0; i < length; i++) {
            if (length < 1) {
                duplication[0] = -1;
                return false;
            }

            //当前元素值，根坐标相同，跳过
            if (numbers[i] == i) {
                continue;
            }

            //当前元素值，等于以它的值为坐标下的值，说明两个元素相同返回true
            if (numbers[i] == numbers[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }

            //交换元素
            int temp = numbers[i];
            numbers[i] = numbers[temp];
            numbers[temp] = temp;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] arr= {2,1,3,1,4};
//        int[] arr= {2,2,1,3,1,4};
        int[] arr = {};
        int[] dup = new int[1];
        duplicate(arr, 0, dup);

        System.out.println(dup[0]);
    }
}
