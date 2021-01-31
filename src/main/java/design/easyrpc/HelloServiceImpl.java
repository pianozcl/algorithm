package design.easyrpc;

/**
 * @author : chenliangzhou
 * create at:  2021/1/25  8:59 PM
 * @description: 服务实现
 **/
public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

    @Override
    public String hi(String msg) {
        return "Hi, " + msg;
    }
}
