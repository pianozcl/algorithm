package stackqueue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : chenliangzhou
 * create at:  2021/1/9  10:37 PM
 * @description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 **/
public class FirstUniqChar {
    LinkedHashMap<Character, Integer> map = new LinkedHashMap();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, 2);
        } else {
            map.put(ch, 1);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        String s = "google";
        for (char c : s.toCharArray()) {
            firstUniqChar.Insert(c);
        }

        System.out.println(firstUniqChar.FirstAppearingOnce());
    }
}
