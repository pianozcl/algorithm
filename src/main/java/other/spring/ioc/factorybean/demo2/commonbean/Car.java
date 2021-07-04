package other.spring.ioc.factorybean.demo2.commonbean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author : chenliangzhou
 * create at:  2021/7/4  6:38 PM
 * @description:
 **/
public class Car {
    private String brand;

    private String speed;

    private String price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
