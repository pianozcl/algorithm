package other.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sun.jvm.hotspot.debugger.Page;

/**
 * @author : chenliangzhou
 * create at:  2021/4/4  8:16 PM
 * @description: aop增强类
 **/
@Component
@Aspect
@Order(1)
public class UserProxy {


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
        System.out.println("before......");
    }

    //后置通知，不管有没有异常都会执行
    @After(value = "execution(* other.spring.aop.User.add(..))")
    public void after() {
        System.out.println("after.....");
    }

    @Around(value = "execution(* other.spring.aop.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前通知");   //before之前执行

        //执行被增强的方法
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后通知");   //after之后执行
    }

    //被增强方法出现异常会执行
    @AfterThrowing(value = "execution(* other.spring.aop.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterthrowing");
    }

    //返回通知，出现异常不会执行
    @AfterReturning(value = "execution(* other.spring.aop.User.add(..))")
    public void afterReturning() {
        System.out.println("afterreturning");
    }
}
