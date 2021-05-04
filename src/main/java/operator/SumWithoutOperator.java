package operator;

/**
 * @author : chenliangzhou
 * create at:  2021/1/23  11:55 PM
 * @description: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C
 **/
public class SumWithoutOperator {

    /**
     * 利用逻辑与运算到短路特性，来作为递归终止条件
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n > 0) && (sum = sum + Sum_Solution(n - 1)) == 100;
        return sum;
    }
}
