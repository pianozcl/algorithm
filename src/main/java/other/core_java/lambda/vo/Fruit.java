package other.core_java.lambda.vo;

/**
 * @author : chenliangzhou
 * create at:  2021/7/2  11:03 PM
 * @description:
 **/
public class Fruit {
    private String name;
    private Integer price;

    public Fruit(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return java.util.Objects.equals(name, fruit.name) &&
                java.util.Objects.equals(price, fruit.price);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, price);
    }
    // 注意equals和hashCode必须成对出现


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
