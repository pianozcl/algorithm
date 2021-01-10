package array;

import java.util.HashMap;

/**
 * @author : chenliangzhou
 * create at:  2021/1/7  4:08 PM
 * @description: 在一个字符串(0 < = 字符串长度 < = 10000 ， 全部由字母组成)中找到第一个只出现一次的字符, 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * "google"
 * 4
 **/
public class FirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char c : chars) {
            //插入元素发现相同元素，覆盖以该元素为key当value值为true，代表这个key是重复元素
            map.put(c, !map.containsKey(c));
        }

        char target = ' ';
        for (char c : chars) {
            //找到第一个重复元素
            if (map.get(c)) {
                target = c;
                break;
            }
        }

        //找到重复元素当下标
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("google"));
    }
}
