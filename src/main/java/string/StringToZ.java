package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/3/10  9:26 PM
 * @description: 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。  比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 **/
public class StringToZ {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            StringBuilder builder = new StringBuilder();
            rows.add(builder);
        }
        int flag = -1, i = 0;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = new StringToZ().convert("PAYPALISHIRING", 3);
        System.out.println(s);
    }
}
