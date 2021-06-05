package other.core_java.io.character_stream.filecopy;

import com.alibaba.fastjson.JSON;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  3:22 PM
 * @description: 字符流，只能操作文本文件，不能操作图片，视频等非文本文件。当我们单纯读或者写文本文件时 使用字符流 其他情况使用字节流
 **/
public class FileCopy {
    public static void main(String[] args) throws Exception{
        FileReader fileReader = new FileReader("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/character_stream/filecopy/file.txt");
        FileWriter fileWriter = new FileWriter("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/character_stream/filecopy/file_copy.txt");
        char[] chars = new char[100];

//        System.out.println(JSON.toJSONString(chars));
//        for (char c : chars) {
//            System.out.println(c);      //qweqweqweqwe0000000000000000000000.....     900+个0
//        }

        int read = fileReader.read();   //当读取单个字符，返回当是当前读取字符（编码）
        System.out.println(read);


        //当read传数组参数，返回当是当前读取字符个数（例如123个字符，100的数组，那么第一次循环len长度为100，第二次循环len长度为23）
        int len = 0;
        while ((len = fileReader.read(chars)) != -1) {
            System.out.println(len);
            fileWriter.write(chars, 0, len);
        }

        fileWriter.flush();
        fileWriter.close();
        fileReader.close();
    }
}
