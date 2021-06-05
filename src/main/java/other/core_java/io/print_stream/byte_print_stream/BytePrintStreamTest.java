package other.core_java.io.print_stream.byte_print_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  10:20 PM
 * @description: 字节打印流
 **/
public class BytePrintStreamTest {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/print_stream/byte_print_stream/file.txt"));
        PrintStream printStream = new PrintStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/print_stream/byte_print_stream/copyfile.txt");
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            printStream.println(line);
        }

        bufferedReader.close();
        printStream.close();
    }
}
