package proxy.dt.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by luwb on 2020/05/06.
 */
public class InvokcationInvokeHandler implements InvocationHandler {

    /**
     * 真实的对象
     */
    private ProxyObj proxyObj;

    public InvokcationInvokeHandler(ProxyObj proxyObj) {
        this.proxyObj = proxyObj;
    }

    /**
     * @param proxy Jvm生成的动态代理对象 $Proxy0
     * @param method 当前代理对象调用的方法对象，是代理对象实现接口中的方法
     * @param args 调用对象传入的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before call set proxy"+proxy.getClass()+" method="+method+" args="+ Arrays.toString(args));
        method.invoke(proxyObj, args);
        return null;
    }
}
