package other.core_java.reflect;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author : chenliangzhou
 * create at:  2021/3/28  4:35 PM
 * @description: 通过反射获取注解
 **/
public class GetAnnotationByReflect {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> dog = Class.forName("other.core_java.reflect.Dog");
        Annotation[] annotations = dog.getAnnotations();

        //获取注解
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获取注解的值
        Table annotation = dog.getAnnotation(Table.class);
        System.out.println(annotation.value());

        Field name = dog.getDeclaredField("name");
        TableField annotation1 = name.getAnnotation(TableField.class);
        System.out.println(annotation1);
        System.out.println(annotation1.colum());
        System.out.println(annotation1.type());


    }

}

/**
 * 通过反射，获取到注解值（例如一些ORM框架，获取注解里面到SQL，即可实现数据库操作）
 */
@Table("dog")
class Dog {

    @TableField(colum = "field_name", type = "String", length = 10)
    String name;

    @TableField(colum = "field_age", type = "int", length = 10)
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String value();
}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface TableField {
    String colum();
    String type();
    int length();

}
