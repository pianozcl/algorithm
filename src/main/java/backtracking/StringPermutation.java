package backtracking;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/6/4  11:48 AM
 * @description: 08.07. 无重复字符串的排列组合 无重复字符串的排列组合。
 * 编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 提示:
 *
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 **/
public class StringPermutation {

    public static void main(String[] args) {

        String[] qwes = permutation("qwe");
        System.out.println(JSON.toJSONString(qwes));

    }

    public static String[] permutation(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        boolean[] used = new boolean[s.length()];
        char[] arr = s.toCharArray();
        recur(arr, list, path, 0, used);
        String[] help = new String[s.length()];
        return list.toArray(help);
    }

    public static void recur(char[] arr, List<String> list, StringBuilder path, int level, boolean[] used) {
        if (level == arr.length) {
            list.add(path.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                path.append(arr[i]);
                used[i] = true;
                recur(arr, list, path, level + 1, used);
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
