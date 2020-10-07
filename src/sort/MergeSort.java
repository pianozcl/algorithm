package sort;

/**
 * @author : chenliangzhou
 * create at:  2020/10/6  4:52 PM
 * @description: 归并排序：分治法，将数组分左右两部分递归拆分合并
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] arr={1,3,2,6,4,9};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sort(int[] arr){
        int[] help=new int[arr.length];
        mergeSort(arr,0,arr.length-1,help);
    }

    public static void mergeSort(int[] arr,int l,int r,int[] help){
        if(l<r){
            int mid=(l+r)/2;
            mergeSort(arr,l,mid,help);
            mergeSort(arr,mid+1,r,help);
            merge(arr,l,mid,r,help);
        }
    }

    public static void merge(int[] arr,int l,int mid,int r,int[] help){
        int i=l;
        int j=mid+1;
        int k=0;
        while (i<=mid&&j<=r){
            if(arr[i]<arr[j]){
                help[k++]=arr[i++];
            }else {
                help[k++]=arr[j++];
            }
        }

        while (i<=mid){
            help[k++]=arr[i++];
        }

        while (j<=r){
            help[k++]=arr[j++];
        }

        k=0;
        while (l<=r){
            arr[l++]=help[k++];
        }

    }
}
