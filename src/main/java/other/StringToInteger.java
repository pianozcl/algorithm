package other;

/**
 * @author : chenliangzhou
 * create at:  2020/9/30  5:39 PM
 * @description: 字符串转整数
 **/
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(atoi("123"));
        int i='0';
        System.out.println(i);
    }

    public static int atoi (String str) {

        int sum=0;
        for(int i=0;i<str.length();i++){
            int val = str.charAt(i);
            sum=sum+val*10^(str.length()-i-1);
        }
        return sum;
    }
}
