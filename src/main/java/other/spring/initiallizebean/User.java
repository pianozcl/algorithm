package other.spring.initiallizebean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @author : chenliangzhou
 * create at:  2021/7/11  11:01 PM
 * @description:
 **/
@Service
public class User implements InitializingBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        name = "张三";
    }
}
