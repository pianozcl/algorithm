package other.core_java.annotation;

import java.lang.annotation.*;

//ElementType（注解在哪有效，如以下定义为可以在方法，和类上面使用）
@Target(value = {ElementType.METHOD, ElementType.TYPE})

//运行时才有效（RetentionPolicy枚举有source源码、class字节码、runtime运行时，此处用的是运行时）
@Retention(value = RetentionPolicy.RUNTIME)

@Documented //表示注解是否生成到doc文档

@Inherited //子类可以集成父类注解
public @interface MyAnnotation {
}


@MyAnnotation
class Test {


    @MyAnnotation
    void test() {

    }

}

