package array;

/**
 * @author : chenliangzhou
 * create at:  2020/9/30  12:57 PM
 * @description: 合并两个有序数组
 **/
public class MergeTwoOrderedArray {
    public static void main(String[] args) {
        int[] arra={1,2,3,4,0,0,0,0,0};
        int[] arrb={3,4,5,7};
        merge(arra,4,arrb,4);

        for (int i : arra) {
            System.out.println(i);
        }


    }


    public static void merge(int A[], int m, int B[], int n) {
        int[] help=new int[m+n];
        int i=0,pA=0,pB=0;
        while (i<(m+n)){
            if(pA<m&&pB<n){
                help[i++]=A[pA]<B[pB]?A[pA++]:B[pB++];
            }
            if(pA>=m&&pB<n){
                help[i++]=B[pB++];
            }
            else if(pB>=n){
                help[i++]=A[pA++];
            }

        }

        for(int j=0;j<help.length;j++){
            A[j]=help[j];
        }
    }
}
