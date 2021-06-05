package other.core_java.io.print_stream.character_print_stream;

import math.SystemTransfer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  10:29 PM
 * @description: 字符输出打印流
 **/
public class CharacterPrintStreamTest {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/print_stream/character_print_stream/file.txt"));
        PrintWriter printWriter = new PrintWriter("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/print_stream/character_print_stream/copyfile.txt");
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            printWriter.println(line);
        }

        bufferedReader.close();
        printWriter.checkError();
    }
}
