package other.design_pattern.factory.simple_factory;

/**
 * @author : chenliangzhou
 * create at:  2021/4/8  11:08 AM
 * @description:
 **/
public class Iphone implements Phone {
    @Override
    public void make() {
        System.out.println("Iphone........");
    }
}
