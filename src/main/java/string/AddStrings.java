package string;

/**
 * @author : chenliangzhou
 * create at:  2021/1/30  8:16 PM
 * @description: 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。 （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 **/
public class AddStrings {

    /**
     * char类型 '0' '1' '2' '3' .....对应整数为48 49 50 51......
     * 所以转整形 '2' - '0' = 50 - 48 =2
     * @param s
     * @param t
     * @return
     */
    public String solve (String s, String t) {
        // write code here
        int lens = s.length() - 1;
        int lent = t.length() - 1;
        int add = 0;
        StringBuffer builder = new StringBuffer();
        while (lent >= 0 || lens >= 0 || add != 0) {
            int i = lens >= 0 ? s.charAt(lens) - '0' : 0;
            int j = lent >= 0 ? t.charAt(lent) - '0' : 0;
            int result = i + j + add;
            builder.append(result % 10);
            add = result / 10;
            lent--;
            lens--;
        }
        builder.reverse();
        return builder.toString();
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        String solve = addStrings.solve("733064366", "459309139");
        System.out.println(solve);
    }
}
