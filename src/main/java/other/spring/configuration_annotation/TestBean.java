package other.spring.configuration_annotation;

import org.springframework.stereotype.Component;

/**
 * @author : chenliangzhou
 * create at:  2021/4/10  9:40 PM
 * @description:
 **/
public class TestBean {
    private String username;
    private String url;
    private String password;

    @Override
    public String toString() {
        return "TestBean{" +
                "username='" + username + '\'' +
                ", url='" + url + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void hello() {
        System.out.println("TestBean hello");
    }

    public void start() {
        System.out.println("TestBean初始化");
    }

    public void cleanUp() {
        System.out.println("TestBean销毁");
    }
}
