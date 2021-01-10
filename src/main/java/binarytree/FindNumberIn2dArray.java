package binarytree;

/**
 *
 * @author : chenliangzhou
 * create at:  2021/1/6  9:18 PM
 * @description:
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 **/
public class FindNumberIn2dArray {

    /**
     * 思路：
     * 从左下角开始，小于当前target row++，大于当前target col--
     */
    public static boolean Find(int target, int [][] array) {
        int col=array.length-1;
        int row=0;

        while (col>=0&&row<=array[0].length-1){
            if(array[col][row]==target){
                return true;
            }else if(array[col][row]>target){
                col--;
            }else if(array[col][row]<target){
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Find(5,arr);
    }
}
