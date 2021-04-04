package other.design_pattern.proxy.static_proxy;

/**
 * @author : chenliangzhou
 * create at:  2021/3/28  10:53 PM
 * @description: CarImpl的静态代理类
 *
 * 与被代理类实现相同的接口
 **/
public class CarProxy implements Car {

    private CarImpl carImpl;

    public CarProxy(CarImpl carImpl) {
        this.carImpl = carImpl;
    }

    @Override
    public void run() {
        System.out.println("代理类");
        carImpl.run();
    }


    public static void main(String[] args) {
        CarProxy carProxy = new CarProxy(new CarImpl());

        carProxy.run();
    }
}
