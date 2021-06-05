package other.core_java.io.cache_stream.character_cached_stream;

import java.io.*;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  4:04 PM
 * @description: 字符缓冲流具备的特有方法。
 * BufferedReader：public String readLine(): 读一行数据。 读取到最后返回null
 * BufferedWriter：public void newLine(): 换行,由系统属性定义符号。
 **/
public class CharacterCachedStreamTest {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/cache_stream/character_cached_stream/file.txt"));

        //单个字符读取
        int read = bufferedReader.read();
        System.out.println((char) read);

        //特有方法，按行读取
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            System.out.println("-----------");
        }
        bufferedReader.close();


        //输出：
        //床前明月
        //第二行
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/cache_stream/character_cached_stream/writerLine.txt"));
        bufferedWriter.write("床");
        bufferedWriter.write("前");
        bufferedWriter.write("明月");

        bufferedWriter.newLine();
        bufferedWriter.write("第二行");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
