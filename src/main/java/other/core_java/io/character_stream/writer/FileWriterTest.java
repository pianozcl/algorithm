package other.core_java.io.character_stream.writer;

import java.io.FileWriter;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  3:06 PM
 * @description:
 **/
public class FileWriterTest {
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/character_stream/writer/filewriter.txt");
        fileWriter.write("呵呵哒");

        //如果不关闭，数据只是保存到缓冲区，并未写入文件
        fileWriter.close();
    }
}
