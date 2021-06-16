package other.core_java.jdk_spi;

import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/6/7  12:31 PM
 * @description:
 **/
public class DatabaseSearch implements Search {
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("数据搜索 "+keyword);
        return null;
    }
}
