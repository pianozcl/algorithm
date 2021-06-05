package other.core_java.io.cache_stream.byte_cached_stream.copy_file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  3:49 PM
 * @description: 大文件拷贝
 **/
public class CopyFile {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/cache_stream/byte_cached_stream/copy_file/game.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/cache_stream/byte_cached_stream/copy_file/copygame.txt");


        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        int len;
        byte[] bytes = new byte[1024];
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }

        fileInputStream.close();
        fileOutputStream.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
