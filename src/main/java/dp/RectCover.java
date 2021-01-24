package dp;

/**
 * @author : chenliangzhou
 * create at:  2021/1/23  2:34 PM
 * @description: 矩形覆盖
 **/
public class RectCover {
    /**
     * 其实还是斐波那契数列
     * @param target
     * @return
     */
    public int rectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int prepre = 0, pre = 1, curr = 0;
        for (int i = 0; i < target; i++) {
            curr = prepre + pre;
            prepre = pre;
            pre = curr;
        }
        return curr;
    }
}
