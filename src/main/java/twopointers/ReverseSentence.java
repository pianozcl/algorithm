package twopointers;

/**
 * @author : chenliangzhou
 * create at:  2021/1/10  2:10 PM
 * @description: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * "nowcoder. a am I"
 *
 * "I am a nowcoder."
 **/
public class ReverseSentence {

    public String reverseSentence(String str) {
        String s = str.trim();
        if (s.isEmpty()) {
            return str;
        }
        int r = s.length() - 1, l = r;
        StringBuilder builder = new StringBuilder();
        while (l >= 0) {
            //双指针，其中 l 指针从右向左遍历，遇到空格说明 l + 1 为当前单词首字母
            while (l >= 0 && s.charAt(l) != ' ') {
                l--;
            }
            builder.append(s.substring(l + 1, r + 1)).append(" ");

            //跳过中间一个或多个空格
            while (l >= 0 && s.charAt(l) == ' ') {
                l--;
            }
            r = l;
        }
        return builder.toString().trim();
    }


    public static void main(String[] args) {
        String s ="  hello ";
        System.out.println(s.substring(1,3));
        String trim = s.trim();
        System.out.println(s.trim());
        System.out.println(s);
    }
}
