package other.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/4/11  3:22 PM
 * @description: 具体的订阅号
 **/
public class SubscriptionSubject implements Subject {

    //维护一个订阅者列表
    private List<Observer> userList = new ArrayList<>();

    @Override
    public void add(Observer observer) {
        userList.add(observer);
    }

    @Override
    public void del(Observer observer) {
        userList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer user : userList) {
            user.update(message);
        }
    }
}
