package other.core_java.io.serialization.serialization;

import java.io.Serializable;

/**
 * @author : chenliangzhou
 * create at:  2021/6/5  6:34 PM
 * @description: 一个对象要想序列化，必须满足两个条件:
 * 该类必须实现java.io.Serializable 接口，Serializable 是一个标记接口，不实现此接口的类将不会使任何状态序列化或反序列化，会抛出NotSerializableException 。
 * 该类的所有属性必须是可序列化的。如果有一个属性不需要可序列化的，则该属性必须注明是瞬态的，使用transient 关键字修饰。
 **/
public class Employee implements Serializable {

    //加入序列化版本，用于验证序列化对象，和对应类是否版本匹配。被序列化的类，反序列的时候UID不同，会抛出异常
    // 假如没有定义，Java会自动生成，而且每次类有改动UID都会变。这样只要类有改动，反序列化就会抛出异常
    // 可以自定义序列化版本号。例如后面字段有改动，只是当前字段反序列化可能无法正常获取值，不会报错，也不会影响其他字段
    private static final long serialVersionUID = 1L;

    public String name;
    public String address;
    public transient Integer age; // transient瞬态修饰成员,不会被序列化


    public String change;     //假如类有改动，会导致反序列化错误
//    public void addressCheck() {
//        System.out.println("Address  check : " + name + " -- " + address);
//    }
}
