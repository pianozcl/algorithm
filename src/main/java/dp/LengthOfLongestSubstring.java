package dp;

import java.util.HashSet;

/**
 * @author : chenliangzhou
 * create at:  2021/1/23  5:14 PM
 * @description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 **/
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s == "") {
            return 0;
        }
        HashSet<Character> set = new HashSet();
        int max = 0;
        int l = 0;  //记录无重复左边界
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {     //包含重复，则从左边界依次remove
                set.remove(s.charAt(l++));
            }
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                max = max > set.size() ? max : set.size();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "bb123123bbbqwer";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}
