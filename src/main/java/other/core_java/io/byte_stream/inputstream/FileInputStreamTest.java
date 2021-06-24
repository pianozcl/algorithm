package other.core_java.io.byte_stream.inputstream;


import java.io.FileInputStream;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  11:09 AM
 * @description: FileInputStream(String name)： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名name命名。
 **/
public class FileInputStreamTest {
    public static void main(String[] args) throws Exception{

        //当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有该文件,会抛出FileNotFoundException
        //FileInputStream inputStream = new FileInputStream("a.txt"); //FileNotFoundException: a.txt (No such file or directory)

        FileInputStream fileInputStream = new FileInputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/inputstream/test.txt");

        //一次read读取一个字节（对于文本来说，英文和数字占一个字节）
        //read方法，每次可以读取一个字节的数据，提升为int类型，读取到文件末尾，返回-1
        byte[] bytes = new byte[3]; //测试文件一个汉子需要3个字节，否则出现乱码
        int read = fileInputStream.read(bytes);
        System.out.println(new String(bytes));      //String构造方法自带解码功能

        int b;
        while ((b = fileInputStream.read()) != -1) {
            System.out.println((char) b);
        }
        fileInputStream.close();


    }
}
