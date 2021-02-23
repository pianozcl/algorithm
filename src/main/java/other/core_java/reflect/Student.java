package other.core_java.reflect;

/**
 * @author : chenliangzhou
 * create at:  2021/2/23  9:29 PM
 * @description: 测试反射类
 **/
public class Student {
    public String name;
    private String age;

    public void print() {
        System.out.println("public method");
    }

    private void print1() {
        System.out.println("private method");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
