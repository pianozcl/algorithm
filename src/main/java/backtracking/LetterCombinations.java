package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : chenliangzhou
 * create at:  2021/4/14  5:27 PM
 * @description: 17. 电话号码的字母组合 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 答案可以按 任意顺序 返回。  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 **/
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrack(list, map,  digits, new StringBuilder());
        return list;
    }

    public void backtrack(List<String> list, Map<Character, String> map,  String digits, StringBuilder builder) {
        if (builder.length() == digits.length()) {
            list.add(builder.toString());
            return;
        }

        char digit = digits.charAt(builder.length());
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            builder.append(letters.charAt(i));
            backtrack(list, map,  digits, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> list = letterCombinations.letterCombinations("");
        System.out.println(list);
    }
}
