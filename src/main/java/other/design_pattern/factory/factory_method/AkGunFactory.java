package other.design_pattern.factory.factory_method;

/**
 * @author : chenliangzhou
 * create at:  2021/4/8  11:38 AM
 * @description:
 **/
public class AkGunFactory implements GunFactory {
    @Override
    public Gun getGun() {
        return new AkGun();
    }
}
