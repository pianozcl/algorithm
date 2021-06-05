package other.core_java.io.character_stream.reader;


import java.io.FileReader;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  2:50 PM
 * @description:
 * 字符流 = 字节流 + 编码表
 **/
public class FileReaderTest {
    public static void main(String[] args) throws Exception{

        //路径文件不存在，回抛出异常FileNotFoundException
        //FileReader fileReader = new FileReader("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/character_stream/reader/xxx");

        FileReader fileReader = new FileReader("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/character_stream/reader/test.txt");
        int b;
        while ((b = fileReader.read()) != -1) {
            System.out.println((char) b);
        }
    }
}
