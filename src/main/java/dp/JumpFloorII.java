package dp;

/**
 * @author : chenliangzhou
 * create at:  2021/1/23  3:13 PM
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 **/
public class JumpFloorII {

    /**
     * 每个台阶都有跳或者不跳两种情况，最后一个台阶必须跳。所以是2^(n-1)
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        return (int)Math.pow(2, target - 1);
    }


    /**
     * f2 = f0 + f1
     * f3 = f0 + f1 + f2
     * f4 = f0 + f1 + f2 + f3
     *
     * ..........
     * fn = 2 * f(n-1)
     * @author zhouchenliang
     * @date 3:16 PM 2021/1/23
     * @param
     * @return
     * @throws
     **/
    public int JumpFloorII2(int target) {
        if (target == 1) {
            return 1;
        }
        return 2 * JumpFloorII(target - 1);
    }
}
