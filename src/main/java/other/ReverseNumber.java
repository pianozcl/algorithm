package other;

/**
 * @author : chenliangzhou
 * create at:  2020/9/28  5:02 PM
 * @description: 将给出的整数x翻转。 例1:x=123，返回321 例2:x=-123，返回-321  你有思考过下面的这些问题么？ 如果整数的最后一位是0，那么输出应该是什么？比如10,100 你注意到翻转后的整数可能溢出吗？假设输入是32位整数，则将翻转10000000003就会溢出，你该怎么处理这样的样例？抛出异常？这样做很好，但是如果不允许抛出异常呢？这样的话你必须重新设计函数（比如添加一个额外的参数）。
 **/
public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(-321));
    }

    public static int reverse (int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            //预判断是否大于Integer最大值2147483647，和是否小于Integer最小值-2147483648
            //例如判断最大边界：rev > Integer.MAX_VALUE / 10  是否大于 214748364，如果等于214748364，再判断最后一位是否越界
            if ((rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) || (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
