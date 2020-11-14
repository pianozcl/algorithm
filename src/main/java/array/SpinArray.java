package array;

import com.alibaba.fastjson.JSON;

/**
 * @author : chenliangzhou
 * create at:  2020/11/14  4:01 PM
 * @description: 旋转数组
 * 一个数组A中存有N（N&gt0）个整数，在不允许使用另外数组的前提下，将每个整数循环向右移M（M>=0）个位置，即将A中的数据由（A0 A1 ……AN-1 ）变换为（AN-M …… AN-1 A0 A1 ……AN-M-1 ）（最后M个数循环移至最前面的M个位置）。如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
 * 输入
 * 6,2,[1,2,3,4,5,6]
 * 返回值
 * [5,6,1,2,3,4]
 *
 * 题解
 *
 * 三次翻转
 * 假设 n=7且 k=3
 * 原始数组                  : 1 2 3 4 5 6 7
 * 反转所有数字后             : 7 6 5 4 3 2 1
 * 反转前 k 个数字后          : 5 6 7    4 3 2 1
 * 反转后 n-k 个数字后        : 5 6 7    1 2 3 4 --> 结果
 **/
public class SpinArray {
    public static void main(String[] args) {
        int[] solve = new SpinArray().solve(6, 4, new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(JSON.toJSONString(solve));
    }

    public int[] solve (int n, int m, int[] a) {
        int k=m%n;
        reverse(a,0,n-1);
        reverse(a,0,k-1);
        reverse(a,k,n-1);
        return a;
    }

    public void reverse(int[] a,int start,int end){
        while (start<end){
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
            start++;
            end--;
        }
    }
}

