package other.core_java.jdk_spi;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author : chenliangzhou
 * create at:  2021/6/7  12:33 PM
 * @description:
 **/
public class TestCase {
    public static void main(String[] args) {

        //resources/META-INF/services创建以接口全类名的文件，文件内容添加实现类的全限定类名
        //为什么是/META-INF/services？因为ServiceLoader定义了路径
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = s.iterator();
        while (iterator.hasNext()) {
            Search search = iterator.next();
            search.searchDoc("hello");
        }

    }
}
