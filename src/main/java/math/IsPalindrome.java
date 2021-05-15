package math;

/**
 * @author : chenliangzhou
 * create at:  2021/4/12  2:56 PM
 * @description: 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。  回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 **/
public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        int p = x;
        if (p < 0) {
            return false;
        }
        int rev = 0;
        while (p != 0) {
            int pop = p % 10;
            p /= 10;

            //Integer.MAX_VALUE最后一位为7。
            if (rev > 0x7fffffff / 10 || (rev == 0x7fffffff / 10 && pop > 7)) {
                return false;
            }
            rev = rev * 10 + pop;
        }
        if (x == rev) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));

        System.out.println(Integer.MAX_VALUE); //2147483647

        int x = 1;
        for (int i = 0; i < 31; i++) {
            x *= 2;
        }
        System.out.println(x - 1); //2147483647
    }
}
