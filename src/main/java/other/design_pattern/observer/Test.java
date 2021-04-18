package other.design_pattern.observer;

/**
 * @author : chenliangzhou
 * create at:  2021/4/11  3:26 PM
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();

        User user1 = new User("张三");
        User user2 = new User("李四");

        subscriptionSubject.add(user1);
        subscriptionSubject.add(user2);

        //张三订阅号更新了
        //李四订阅号更新了
        subscriptionSubject.notify("订阅号更新了");
    }
}
