package other.design_pattern.adapter;

/**
 * @author : chenliangzhou
 * create at:  2021/3/31  11:01 PM
 * @description: 适配器
 *
 *
 **/
public class Adapter implements Target{

    /**
     * 客户端只能调用target的接口的request方法，但是目前实现Adaptee（被适配者）已经实现了special方法。
     * 为了能够复用Adaptee的方法，又能兼容target接口，这时候定义了一个Adapter实现target，并将Adaptee作为属性
     * 将
     */

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        //在request方法中，调用被适配者已经实现的specialRequest方法
        adaptee.specialRequest();
    }
}
