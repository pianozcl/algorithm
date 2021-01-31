package design.easyrpc;

/**
 * @author : chenliangzhou
 * create at:  2021/1/25  9:00 PM
 * @description: 服务引用：消费端通过RPC框架进行远程调用，这也是RPC框架功能之一
 **/
public class RpcConsumer {
    public static void main(String[] args) throws Exception {
        // 由RpcFramework生成的HelloService的代理
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
        String hello = service.hello("World");
        System.out.println("客户端收到远程调用的结果 ： " + hello);
    }
}
