package other.jvm;

/**
 * @author : chenliangzhou
 * create at:  2021/3/28  2:21 PM
 * @description:
 **/
public class TestClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {

        //获取系统类加载器s
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);


        //扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //根加载器
        System.out.println(parent.getParent());     //null


        ClassLoader classLoader = Class.forName("other.jvm.TestClassLoader").getClassLoader();
        System.out.println(classLoader); //Launcher$AppClassLoader

        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1); //null

        System.out.println(System.getProperty("java.class.path"));
    }
}
