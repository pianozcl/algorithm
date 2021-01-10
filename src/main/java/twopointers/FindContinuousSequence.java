package twopointers;

import java.util.ArrayList;

/**
 * @author : chenliangzhou
 * create at:  2021/1/10  1:07 PM
 * @description: 小明很喜欢数学, 有一天他在做数学作业时, 要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * <p>
 * 输入 ：9
 * 输出 ：[[2,3,4],[4,5]]
 **/
public class FindContinuousSequence {

    /**
     * 思路 ： 推出数学公式 ：temp = (l + r) * (r - l + 1) / 2;   例如 9 = （2 + 4） * （4 - 2 + 1） / 2 。
     * temp < sum 右移 r 指针，以增大序列和 temp
     * temp > sum 左移 l 指针，以减小序列和 temp
     * temp == sum 把当前 l ~ r 区间的的序列放进一个子list集合中
     **/
    public ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int l = 1, r = 2; l < r;) {
            int temp = (l + r) * (r - l + 1) / 2;
            if (temp == sum) {
                ArrayList<Integer> childList = new ArrayList<>();
                for (int j = l; j <= r; j++) {
                    childList.add(j);
                }
                list.add(childList);
                l++;
            } else if (temp < sum) {
                r++;
            } else {
                l++;
            }
        }
        return list;
    }
}
