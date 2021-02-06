package string;

/**
 * @author : chenliangzhou
 * create at:  2021/2/6  11:23 PM
 * @description: 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串
 **/
public class ReverseString {
    public String solve (String str) {
        // write code here
        char[] arr = str.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return String.valueOf(arr);
    }
}
