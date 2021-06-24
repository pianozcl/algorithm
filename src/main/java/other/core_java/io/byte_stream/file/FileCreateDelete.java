package other.core_java.io.byte_stream.file;

import java.io.File;
import java.io.IOException;

/**
 * @author : chenliangzhou
 * create at:  2021/6/4  2:36 PM
 * @description: 创建删除文件
 **/
public class FileCreateDelete {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/file/hello.txt");
        System.out.println(file.exists());  //false
        System.out.println(file.createNewFile());   //true
        System.out.println(file.createNewFile());   //false,因为已经创建过了
        System.out.println(file.exists());          //true

        System.out.println("---------创建多层级目录-------");

        File dir = new File("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/file/dir/dir");
        System.out.println(dir.exists());   //false
        System.out.println(dir.mkdir());    //false mkdir用于创建单层目录
        System.out.println(dir.mkdirs());   //true,这里注意，mkdirs用于创建多级目录

        System.out.println("--------删除------");
        System.out.println(file.delete());  //文件删除
        System.out.println(dir.delete());   //目录删除，删除一级
    }
}
