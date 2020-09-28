package array;

/**
 * @author : chenliangzhou
 * create at:  2020/9/28  3:55 PM
 * @description: 数组中未出现的最小正数,时间复杂度O(n),空间复杂度O(1)
 **/
public class MinNumberdisappered {

    public static void main(String[] args) {
        int[] arr={3,4,-1,2};
        System.out.println(minNumberdisappered(arr));
    }

    /**
     * 简单的解法
     * 把每个数置换到它应该在的位置,置换完成的数组应该满足arr[i]=i-1,如果某个下标不满足，说明此下标存在空缺
     *
     * 例如3，4，1，2置换完了就是1，2，3，4。最小正数为5
     *
     * 例如：3，4，-1，2
     * 3的下标应该是2，也就是-1的位置，所以跟1交换，-1，4，3，2
     * 4的下标应该是3，也就是2的位置，所以跟2交换， -1，2，3，4
     */
    public static int minNumberdisappered (int[] arr) {

        for(int i=0;i<arr.length;i++){
            if(arr[i]>0 && arr[i]<=arr.length && arr[i]!=arr[arr[i]-1]){
                int temp=arr[arr[i]-1];
                arr[arr[i]-1]=arr[i];
                arr[i]=temp;
            }
        }

        //遍历完成交换的数组，如果下标不满足arr[i]=i-1，说明这个地方存在正数空缺
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return arr.length+1;
    }
}
