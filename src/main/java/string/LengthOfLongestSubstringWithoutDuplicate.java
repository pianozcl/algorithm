package string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author : chenliangzhou
 * create at:  2021/7/27  9:25 AM
 * @description: 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 **/
public class LengthOfLongestSubstringWithoutDuplicate {
    public int lengthOfLongestSubstring(String s) {
        LinkedList<Character> queue = new LinkedList();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            while (queue.contains(s.charAt(i))) {
                queue.poll();
            }
            queue.add(s.charAt(i));
            if (queue.size() > max) {
                max = queue.size();
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet();
        int left = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(i));
            max = max > set.size() ? max : set.size();
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "qrsvbspk";
        int i = lengthOfLongestSubstring2(s);
        System.out.println(i);
    }
}
