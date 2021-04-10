package other.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author : chenliangzhou
 * create at:  2021/4/4  8:48 PM
 * @description: 第二个AOP类，测试AOP权重
 * order小的先执行
 *
 * 环绕之前通知
 * before......
 * Proxy 2 before......
 * add....
 * afterreturning
 * after.....
 * 环绕之后通知
 **/
@Component
@Aspect
@Order(2)
public class UserProxy2 {

    //抽取相同切入点，例如下面的before方法可以替换为@Before(value = "pointCut()")
    @Pointcut(value = "execution(* other.spring.aop.User.add(..))")
    public void pointCut() {

    }


    //execution表达式
    //* 修饰符（代表public private等都可以）
    //spring.aop.User 包名 类名
    //方法
    //..参数列表
    @Before(value = "pointCut()")
    public void before() {
        System.out.println("Proxy 2 before......");
    }
}
