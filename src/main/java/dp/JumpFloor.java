package dp;

/**
 * @author : chenliangzhou
 * create at:  2021/1/23  2:46 PM
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 **/
public class JumpFloor {
    /**
     * 其实是斐波那契数列
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int prepre = 1, pre = 2, curr = 0;
        for (int i = 3; i <= target; i++) {
            curr = prepre + pre;
            prepre = pre;
            pre = curr;
        }
        return curr;
    }


    /**
     * 递归版本
     * @param target
     * @return
     */
    public int JumpFloor2(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}
