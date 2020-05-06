package proxy.dt.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by luwb on 2020/05/06.
 */
public class CglibProxy implements MethodInterceptor {

    /**
     *  cglib代理是通过继承被代理类的方式进行代理的
     *
     * @param o 目标实例对象（继承于传入的被代理类）
     * @param method 目标方法对象
     * @param objects 方法参数
     * @param methodProxy 代理对象实例
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //o.toString o.equals o.hashCode方法调用都会导致方法栈溢出
        System.out.println("o=" + o.getClass() + " method=" + method + " args=" + Arrays.toString(objects) + " proxy=" + methodProxy);
        System.out.println("before call add extra logic");
        //调用父类(被代理类)的方法
        boolean result = (Boolean) methodProxy.invokeSuper(o, objects);
        System.out.println("after call add extra logic");
        return result;
    }
}
