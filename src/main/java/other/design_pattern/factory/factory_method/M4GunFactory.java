package other.design_pattern.factory.factory_method;

/**
 * @author : chenliangzhou
 * create at:  2021/4/8  11:38 AM
 * @description:
 **/
public class M4GunFactory implements GunFactory {
    @Override
    public Gun getGun() {
        return new M4Gun();
    }

    public static void main(String[] args) {
        AkGunFactory akGunFactory = new AkGunFactory();
        akGunFactory.getGun().fire();
    }
}
