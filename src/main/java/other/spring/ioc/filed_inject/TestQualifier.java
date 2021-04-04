package other.spring.ioc.filed_inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import other.spring.ioc.filed_inject.dao.Dao;

/**
 * @author : chenliangzhou
 * create at:  2021/4/4  12:27 AM
 * @description: 按名称注入，需配合Autowired使用
 **/
@Component
public class TestQualifier {

    @Autowired
    @Qualifier(value = "twoDao")
    private Dao dao;

    public void print() {
        dao.print();
    }
}
