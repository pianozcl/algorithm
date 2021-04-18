package other.design_pattern.observer;

/**
 * @author : chenliangzhou
 * create at:  2021/4/11  3:17 PM
 * @description:
 *
 * 用户类定义
 **/
public class User implements Observer {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String message) {
        System.out.println(userName + message);
    }
}
