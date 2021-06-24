package other.core_java.io.byte_stream.copyimage;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  12:23 PM
 * @description:
 **/
public class CopyImage {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/copyimage/image.png");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/copyimage/image_copy.png");

        //byte[] bytes = new byte[1024 * 1024];   //300891，一次读取1M，图片不到1M，因此只需要读取一次

        //一次读取1kb,整个图片401k，需要多次读取
        byte[] bytes = new byte[1024];  //最终打印1024 1024 1024......507。
        int len;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
            System.out.println(len);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
