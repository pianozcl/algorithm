package sort;

/**
 * @author : chenliangzhou
 * create at:  2020/10/5  11:06 PM
 * @description: 选择排序
 * 排序方式：1.首先找到数组中最小的元素，与第一个元素交换，第二次找到剩下元素中最小的，与第二个数交换，如此往复
 **/
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr={1,3,2,6,4,9};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sort(int[] arr){
        for(int i=0;i<arr.length;i++){

            //最小元素的索引
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }

            //交换
            if(min!=i){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
    }
}
