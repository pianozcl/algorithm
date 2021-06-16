package other.core_java.jdk_spi;

import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/6/7  12:30 PM
 * @description:
 **/
public class FileSearch implements Search {

    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("文件搜索 "+keyword);
        return null;
    }
}
