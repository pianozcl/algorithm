package other.core_java.io.serialization.deserialization;

import other.core_java.io.serialization.serialization.Employee;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  9:47 PM
 * @description: 反序列化对象
 **/
public class DeserializeObject {
    public static void main(String[] args)throws Exception{
        FileInputStream fileInputStream = new FileInputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/serialization/serialization/employee.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Employee e = (Employee)objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();

        System.out.println(e.address);
        System.out.println(e.name);
        System.out.println(e.age);      //用transient修饰，所以没有进行序列化，反序列化为null
        System.out.println(e.change);
    }
}
