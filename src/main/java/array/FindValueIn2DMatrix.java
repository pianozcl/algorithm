package array;

/**
 * @author : chenliangzhou
 * create at:  2020/10/3  11:56 PM
 * @description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 **/
public class FindValueIn2DMatrix {


    public boolean bruteFind(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(array[i][j]==target){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean find(int target, int [][] array) {
        int i=array.length-1;
        int j=0;
        while (i>=0&&j<=array[0].length-1){
            if(target<array[i][j]){
                i--;
            }else if(target>array[i][j]){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }
}
