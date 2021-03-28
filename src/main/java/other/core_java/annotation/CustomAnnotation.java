package other.core_java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {

    //参数，并非方法。参数类型 参数名（），默认值""，没有默认值必须给注解赋值
    String name() default "";
}
