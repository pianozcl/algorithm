package design.easyrpc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : chenliangzhou
 * create at:  2021/1/25  8:59 PM
 * @description: 服务暴露：只有把服务暴露出来，才能让客户端进行调用，这是RPC框架功能之一。
 **/
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        // RPC框架将服务暴露出来，供客户端消费
        RpcFramework.export(service, 1234);
    }
}
