package other.core_java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : chenliangzhou
 * create at:  2021/2/23  9:31 PM
 * @description: 痛过反射获取class
 *
 * 反射使Java具有动态语言特性，在运行时获取类信息，并能够操作属性和方法
 *
 * 正常创建对象 引入包名》创建对象》取得对象实例
 * 反射 实例对象》getClass方法》获取完整包名类名
 **/
public class GetClassByReflect {

    public static void main(String[] args) throws Exception {

        //获取Class对象方式1
        System.out.println("获取Class对象方式1");
        Student student = new Student();
        Class<? extends Student> clazz1 = student.getClass();
        System.out.println(clazz1.getName());

        //获取Class对象方式2
        System.out.println("获取Class对象方式2");
        Class<Student> clazz2 = Student.class;
        System.out.println(clazz1 == clazz2);  //true,因为运行时一个类只有一个class对象

        //获取Class对象方式3
        System.out.println("获取Class对象方式3");
        Class<?> clazz3 = Class.forName("other.core_java.reflect.Student");
        System.out.println(clazz1 == clazz3); //true


        //判断类型
        System.out.println("判断类型");
        System.out.println(student instanceof Student); //true
        System.out.println(clazz1.isInstance(student)); //true,判断是否为某个类的实例

        //获取实例
        System.out.println("获取实例");
        clazz1.newInstance().print();   //痛过Class的newInstance
        clazz1.getConstructor().newInstance().print(); //痛过Construct的newInstance获取对象，再调用


        //反射获取构造方法
        System.out.println("反射获取构造方法");
        Constructor<?>[] constructors = clazz1.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        //获取成员变量
        System.out.println("获取public成员变量");
        Field[] fields = clazz1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("获取所有成员变量");
        Field[] declaredFields = clazz1.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        System.out.println("获取共有方法");
        Method[] methods = clazz1.getMethods();
        for (Method method : methods) {
            System.out.println(method); //还会打印父类方法，比如Object的方法
        }

        System.out.println("获取所有方法");
        Method[] declaredMethods = clazz1.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredFields);
        }


        Class integerClass1 = Integer.class;
        Class<Integer> integerClass2 = Integer.TYPE;
        System.out.println(integerClass1.hashCode());
        System.out.println(integerClass2.hashCode());
    }
}
