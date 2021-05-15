package other.spring.circular_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : chenliangzhou
 * create at:  2021/5/10  2:07 AM
 * @description:
 **/
@Component
public class B {
    @Autowired
    private A a;

    void print() {
        System.out.println("b");
    }
}
