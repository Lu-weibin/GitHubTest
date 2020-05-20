package proxy.dt.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by luwb on 2020/05/19.
 */
public class Main {

    public static void main(String[] args1) {
        ProxyObj proxyObj = new ProxyObjImpl();
        ProxyObj proxyInstance = (ProxyObj) Proxy.newProxyInstance(proxyObj.getClass().getClassLoader(), proxyObj.getClass().getInterfaces(), (proxy, method, args) -> {
            if (("setName").equals(method.getName())) {
                method.invoke(proxyObj, args);
                System.out.println("调用了setName方法");
            } else {
                method.invoke(proxyObj, args);
            }
            return null;
        });

        proxyInstance.setAge(18);
        proxyInstance.setName("luweibin");
    }

}
