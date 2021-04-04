package other.design_pattern.adapter;

/**
 * @author : chenliangzhou
 * create at:  2021/3/31  11:00 PM
 * @description: 需要被适配的类
 **/
public class Adaptee {
    public void specialRequest() {
        System.out.println("specialRequest");
    }
}
