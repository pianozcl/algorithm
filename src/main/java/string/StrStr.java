package string;

/**
 * @author : chenliangzhou
 * create at:  2021/5/15  2:22 PM
 * @description: 实现 strStr() 函数。  给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。   
 * 说明：  当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。  对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 * 这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。   
 * 示例 1：  输入：haystack = "hello", needle = "ll" 输出：2
 * 示例 2：  输入：haystack = "aaaaa", needle = "bba" 输出：-1
 * 示例 3：  输入：haystack = "", needle = "" 输出：0
 **/
public class StrStr {
    public static int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        //haystack.length() - needle.length()防止数组下标越界
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0, start = i; j < needle.length(); j++) {
                //当前字符不匹配，break
                if (needle.charAt(j) != haystack.charAt(start)) {
                    break;
                }

                //当needle最后一个字符匹配，说明当前i为匹配当开始下标，直接返回
                if (j == needle.length() - 1) {
                    return i;
                }
                start++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }
}
