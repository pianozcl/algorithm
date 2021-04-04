package other.design_pattern.adapter;

/**
 * @author : chenliangzhou
 * create at:  2021/3/31  11:08 PM
 * @description: 使用适配器的客户端
 **/
public class Client {
    public static void main(String[] args) {

        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);

        adapter.request();
    }
}
