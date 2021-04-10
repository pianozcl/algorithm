package other.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author : chenliangzhou
 * create at:  2021/4/4  8:15 PM
 * @description:
 **/
@Component
public class User {
    public void add() {
        //int i = 10 / 0;   //模拟异常，将会执行afterthrowing通知。下面add将不会执行
        System.out.println("add....");
    }
}
