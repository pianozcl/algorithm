package binary;

/**
 * @author : chenliangzhou
 * create at:  2021/1/23  11:02 PM
 * @description: 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 **/
public class NumberOf1 {
    /**
     * 每一位与当前对应的掩码与运算，如果不等于0，说明该位为1
     * 掩码加左移动，以从低位到高位比较
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }
}
