package other.spring.ioc.filed_inject.dao;

import org.springframework.stereotype.Component;

/**
 * @author : chenliangzhou
 * create at:  2021/4/4  12:24 AM
 * @description: Dao的实现类
 **/
@Component
public class OneDao implements Dao {
    @Override
    public void print() {
        System.out.println("One");
    }
}
