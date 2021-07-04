package other.spring.ioc.factorybean.demo2.factorybeantest;

import org.springframework.beans.factory.FactoryBean;
import other.spring.ioc.factorybean.demo2.commonbean.Car;

/**
 * @author : chenliangzhou
 * create at:  2021/7/4  6:39 PM
 * @description:
 **/
public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }


    /**
     * FactoryBean可以使创建bean的方式更加灵活。例如想要为Car注入一些属性，在Configation或者xml配置类中，无需为car设置每个属性
     * 直接通过在Configation配置类或者xml中，@Bean或者bean标签的形式声明一个CarFactoryBean对象。那么可以通过getObject返回Car的对象
     *
     * 本例：car有三个属性，可以通过工厂bean的carInfo属性，作字符串切割，得到brand，speed，和price属性，并为car赋值
     *
     * 这对于复杂bean的创建有很大帮助
     * @return
     * @throws Exception
     */
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] split = carInfo.split(",");
        car.setBrand(split[0]);
        car.setSpeed(split[1]);
        car.setPrice(split[2]);
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
}
