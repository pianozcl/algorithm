package other.core_java.io.byte_stream.file;

import java.io.File;

/**
 * @author : chenliangzhou
 * create at:  2021/6/4  2:22 PM
 * @description:
 * File跟流无关，File类不能对文件进行读和写也就是输入和输出！
 * File主要表示类似D:\\文件目录1与D:\\文件目录1\\文件.txt,前者是文件夹（Directory）后者则是文件(file)，而File类就是操作这两者的类。
 **/
public class FileApi {
    public static void main(String[] args) {
        //并没有真正创建文件，因为File不能对文件进行输入和输出
        File file = new File("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/file/hello.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.length());

        System.out.println(file.exists()); //false
        System.out.println(file.isFile()); //false
        System.out.println(file.isDirectory()); //false
    }
}
