package proxy.dt.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by luwb on 2020/05/06.
 */
public class ProxyFactory {

    /**
     * 获取代理对象
     */
    private static ProxyObj getProxy(ProxyObj proxyObj) {
        return (ProxyObj) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                proxyObj.getClass().getInterfaces(), new InvokcationInvokeHandler(proxyObj));
    }

    public static void main(String[] args) {
        ProxyFactory.getProxy(new ProxyObjImpl()).setAge(24);
    }

}
