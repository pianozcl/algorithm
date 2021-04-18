package other.design_pattern.observer;

/**
 * 被观察者，例如一个订阅号
 * @author zhouchenliang
 * @date 3:18 PM 2021/4/11
 * @param
 * @return
 * @throws
 **/
public interface Subject {

    //添加订阅者
    public void add(Observer observer);

    //删除订阅者
    public void del(Observer observer);

    //通知订阅者
    public void notify(String message);
}
