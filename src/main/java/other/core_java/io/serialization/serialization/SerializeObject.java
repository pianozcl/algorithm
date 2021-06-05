package other.core_java.io.serialization.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  6:38 PM
 * @description: 写出对象
 **/
public class SerializeObject {
    public static void main(String[] args) throws Exception{
        Employee employee = new Employee();
        employee.name = "张三";
        employee.address = "花果山水帘洞";
        employee.age = 100;
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/core_java/io/serialization/serialization/employee.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employee);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
