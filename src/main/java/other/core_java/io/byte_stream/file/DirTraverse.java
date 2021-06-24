package other.core_java.io.byte_stream.file;

import com.alibaba.fastjson.JSON;

import java.io.File;

/**
 * @author : chenliangzhou
 * create at:  2021/6/4  2:53 PM
 * @description: 目录遍历
 **/
public class DirTraverse {
    public static void main(String[] args) {
        File dir = new File("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/file");
        String[] list = dir.list();     //获取文件以及文件夹对名字
        System.out.println(JSON.toJSONString(list));

        File[] files = dir.listFiles();     //获取文件以及文件夹File对象，对象可以获取更多对信息
        System.out.println(JSON.toJSONString(files));
    }
}
