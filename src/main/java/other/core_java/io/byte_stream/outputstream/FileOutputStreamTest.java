package other.core_java.io.byte_stream.outputstream;

import java.io.FileOutputStream;

/**
 * @author : chenliangzhou
 * create at:  2021/6/4  4:08 PM
 * @description: 字节输出流-》文件输出流
 **/
public class FileOutputStreamTest {
    public static void main(String[] args) throws Exception{

        //写出字节
        FileOutputStream outputStream = new FileOutputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/outputstream/fileoutstream.txt");
        outputStream.write(97);
        outputStream.write('b');
        outputStream.write(99); //输出文件内容abc
        outputStream.close();

        //写出字节数组
        FileOutputStream outputStream2 = new FileOutputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/outputstream/fileoutstream_byte_array.txt");
        byte[] bytes = "写出字节数组".getBytes();
        outputStream2.write(bytes);
        outputStream2.close();

        //写出制定长度字节数组
        FileOutputStream outputStream3 = new FileOutputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/outputstream/fileoutstream_byte_array_with_length.txt");
        outputStream3.write("12345678".getBytes(), 2, 2);   //34
        outputStream3.close();


        //实现追加写,构造方法第二个参数true
        FileOutputStream outputStream4 = new FileOutputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/outputstream/fileoutstream.txt", true);
        for (int i = 0; i < 3; i++) {
            outputStream4.write("追加内容\n".getBytes());       //\n换行追加写入
        }

    }
}
