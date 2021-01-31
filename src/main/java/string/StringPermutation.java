package string;

import java.util.*;

/**
 * @author : chenliangzhou
 * create at:  2021/1/30  10:36 PM
 * @description: 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 **/
public class StringPermutation {

    ArrayList<String> res = new ArrayList<>();
    char[] c;
    public ArrayList<String> Permutation(String str) {
        c = str.toCharArray();
        dfs(0);
        Collections.sort(res);
        return res;
    }

    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) {
                continue; // 重复，因此剪枝
            }
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }
    void swap(int a, int b) {
        if (a == b) {
            return;
        }
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        StringPermutation stringPermutation = new StringPermutation();
        ArrayList<String> abc = stringPermutation.Permutation("abc");
        System.out.println("aaa");
        System.out.println(abc);
    }
}
