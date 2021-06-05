package other.core_java.io.encode;

import java.io.*;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  5:11 PM
 * @description: 测试编解码
 **/
public class EncodeDecodeTest {
    public static void main(String[] args) throws Exception{

        //可通过第二个参数指定编码，编码不对会出现乱码
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/encode/a.txt"),"GBK");
        int read = inputStreamReader.read();
        System.out.println((char) read);
        inputStreamReader.close();

        //idea默认UTF-8，以GBK编码输出，打开文件出现乱码
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/encode/a.txt",true),"GBK");
        outputStreamWriter.write("输出");
        outputStreamWriter.close();
    }
}
