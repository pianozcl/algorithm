package other.design_pattern.proxy.static_proxy;

/**
 * @author : chenliangzhou
 * create at:  2021/3/28  10:52 PM
 * @description: Car接口实现类
 **/
public class CarImpl implements Car {
    @Override
    public void run() {
        System.out.println("Car is running......");
    }
}
