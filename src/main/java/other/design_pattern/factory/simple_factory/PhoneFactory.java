package other.design_pattern.factory.simple_factory;

/**
 * @author : chenliangzhou
 * create at:  2021/4/8  11:14 AM
 * @description:
 **/
public class PhoneFactory {
    public static Phone getPhone(String type) {
        Phone phone = null;
        if ("iphone".equals(type)) {
            phone = new Iphone();
        }
        if ("miphone".equals(type)) {
            phone = new MiPhone();
        }
        return phone;
    }

    public static void main(String[] args) {
        Phone iphone = getPhone("iphone");
        iphone.make();
    }
}
