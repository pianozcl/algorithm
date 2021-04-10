package string;

/**
 * @author : chenliangzhou
 * create at:  2021/4/8  2:07 PM
 * @description: 编写一个函数来查找字符串数组中的最长公共前缀。  如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 **/
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int max = strs[0].length();     //以第一个字符串为基准，公共前缀不会超过这个长度
        for (int i = 0; i < max; i++) {     // i记录最长公共前缀右边界
            for (int j = 0; j < strs.length; j++) {
                //如果有其中一个字符串==i，说明这个字符串最大长度就为i，直接返回。或者是i下标下的字符不一样，说明也达到了最大前缀边界
                if (strs[j].length() == i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] s = new String[]{"flower","fxow","flxxxxxght"};
        System.out.println(longestCommonPrefix(s));


        System.out.println();
    }
}
