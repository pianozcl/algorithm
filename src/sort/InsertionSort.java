package sort;

/**
 * @author : chenliangzhou
 * create at:  2020/10/6  2:49 PM
 * @description: 插入排序：一个数组左边是排好序的部分，右边是未排序的部分，从未排序的部分选取第一个数，插入排好序正确的位置
 **/
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr={1,3,2,6,4,9};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }
}
