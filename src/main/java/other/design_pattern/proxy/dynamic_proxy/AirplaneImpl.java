package other.design_pattern.proxy.dynamic_proxy;

/**
 * @author : chenliangzhou
 * create at:  2021/3/28  11:51 PM
 * @description:
 **/
public class AirplaneImpl implements Airplane {
    @Override
    public void fly() {
        System.out.println("flying........");
    }

    @Override
    public void land(String location) {
        System.out.println("landing" + location);
    }
}
