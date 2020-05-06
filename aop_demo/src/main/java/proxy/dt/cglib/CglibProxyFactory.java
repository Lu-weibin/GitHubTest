package proxy.dt.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by luwb on 2020/05/06.
 * 产生代理对象的工厂
 */
public class CglibProxyFactory {

    private Enhancer enhancer = new Enhancer();
    private CglibProxy cglibProxy = new CglibProxy();

    public Object getProxyObject(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(cglibProxy);
        return enhancer.create();
    }
}
