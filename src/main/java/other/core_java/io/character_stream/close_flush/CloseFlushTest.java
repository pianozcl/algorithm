package other.core_java.io.character_stream.close_flush;

import java.io.FileWriter;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  3:14 PM
 * @description: 因为内置缓冲区的原因，如果不关闭输出流，无法写出字符到文件中。但是关闭的流对象，是无法继续写出数据的。
 * 如果我们既想写出数据，又想继续使用流，就需要flush 方法了。
 * flush ：刷新缓冲区，流对象可以继续使用。
 * close:先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。
 **/
public class CloseFlushTest {
    public static void main(String[] args) throws Exception{


        //续写，第二个参数设置为true
        FileWriter fileWriter = new FileWriter("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/character_stream/close_flush/text.txt");
        fileWriter.write('刷');   //写出第一个字符
        fileWriter.flush();
        fileWriter.write("新"); //继续写第二个字符
        fileWriter.flush();

        fileWriter.write('关');
        fileWriter.close();
        fileWriter.write('关');      //java.io.IOException: Stream closed
    }
}
