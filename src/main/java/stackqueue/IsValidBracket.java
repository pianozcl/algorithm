package stackqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author : chenliangzhou
 * create at:  2021/4/16  10:35 AM
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。  有效字符串需满足：  左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 *
 **/
public class IsValidBracket {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            //栈为空，且当前为）}],返回false
            if (stack.size() == 0 && !map.containsKey(s.charAt(i))) {
                return false;
            }

            if (!map.containsKey(s.charAt(i))) {
                //当前为右括号，假如跟栈顶元素不对称返回false，对称则pop
                if (map.get(stack.peek()) != s.charAt(i)) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                //当前元素为左括号，直接压栈
                stack.push(s.charAt(i));
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean valid = isValid("()");
        System.out.println(valid);
    }
}
