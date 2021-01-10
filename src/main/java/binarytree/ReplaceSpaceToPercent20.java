package binarytree;


/**
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author : chenliangzhou
 * create at:  2021/1/6  10:18 PM
 * @description:
 **/
public class ReplaceSpaceToPercent20 {
    public static String replaceSpace(StringBuffer str) {
        int spaceCount=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                spaceCount++;
            }
        }

        int oldRightIndex=str.length()-1;
        str.setLength(str.length()+spaceCount*2);
        int newRightIndex=str.length()-1;
        for(int i=oldRightIndex;i>=0;i--){
            if(str.charAt(i)==' '){
                str.setCharAt(newRightIndex--,'0');
                str.setCharAt(newRightIndex--,'2');
                str.setCharAt(newRightIndex--,'%');
            }else {
                str.setCharAt(newRightIndex--, str.charAt(i));
            }
        }
        return str.toString();
    }

    public static String replaceSpace2(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello world hhe");
        String string = replaceSpace2(stringBuffer);
        System.out.println(string);
    }
}
