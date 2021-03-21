package sort;

/**
 * @author : chenliangzhou
 * create at:  2020/10/6  4:52 PM
 * @description: 归并排序：分治法，将数组分左右两部分递归拆分合并
 *
 * 递归时间复杂度分析
 * master公式
 * T(N) = a * T(N/b) + O(N^d)
 * log(b, a) > d -> O(N ^ log (b, a))
 * log(b, a) = d -> O(N ^ d * logN)
 * log(b, a) > d -> O(N ^ d)
 *
 * 归并排序：N*logN
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] arr={4,5,1,2,8,3,6,7};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sort(int[] arr){
        int[] help=new int[arr.length];
        mergeSort(arr,0,arr.length-1,help);
    }

    /**
     *
     * @param arr 初始数组
     * @param l 左边界
     * @param r 右边界
     * @param help  辅助用的新数组
     */
    public static void mergeSort(int[] arr,int l,int r,int[] help){
        if(l<r){
            //将原始数组拆分成两个数组，当然递归的终止条件是l=r也就是拆分为单个元素的数组
            int mid=(l+r)/2;

            //递归排序左边的数组
            mergeSort(arr,l,mid,help);//T(N/2)

            //递归排序右边的数组
            mergeSort(arr,mid+1,r,help);//T(N/2)

            //合并以上两个排好序的数组
            merge(arr,l,mid,r,help);//T(N) = 2T(N/2) + O(N)
        }
    }

    /**
     * 将两个有序数组合并为一个有序数组
     * @param arr 原始数组
     * @param l   第一个数组左边界
     * @param mid  第一个数组右边界，（mid+1）为第二个数组左边界
     * @param r  第二个数组右边界
     * @param help  辅助用的新数组
     */
    public static void merge(int[] arr,int l,int mid,int r,int[] help){
        int i=l;
        int j=mid+1;
        int k=0;

        //循环遍历并比较两个数组元素，并把小的一方塞进新数组中
        while (i<=mid&&j<=r){
            if(arr[i]<arr[j]){
                help[k++]=arr[i++];
            }else {
                help[k++]=arr[j++];
            }
        }

        //以下两个while则是，如果有一方元素已经全部塞进新数组了，那么直接把剩下一方的剩下元素依次塞入新数组
        while (i<=mid){
            help[k++]=arr[i++];
        }

        while (j<=r){
            help[k++]=arr[j++];
        }

        //最后把help数组赋值给原始数组，合并完毕
        k=0;
        while (l<=r){
            arr[l++]=help[k++];
        }

    }
}
