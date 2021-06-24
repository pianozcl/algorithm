package other.core_java.io.byte_stream.file;

import java.io.File;

/**
 * @author : chenliangzhou
 * create at:  2021/6/4  3:59 PM
 * @description: 递归遍历文件夹下所有文件以及子文件
 **/
public class RecursionDirectory {
    public static void main(String[] args) {
        File file = new File("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java");
        recur(file);
    }

    public static void recur(File file) {
        //不是目录直接推出
        if (!file.isDirectory()) {
            return;
        }

        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                recur(f);   //是目录递归
            } else {
                System.out.println(f.getName());    //不是目录，打印文件名字
            }
        }
    }
}
