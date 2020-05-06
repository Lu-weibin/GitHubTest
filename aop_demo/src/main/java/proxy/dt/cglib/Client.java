package proxy.dt.cglib;

/**
 * Created by luwb on 2020/05/06.
 */
public class Client {

    public static void main(String[] args) {
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory();
        Query proxyObject = (Query) cglibProxyFactory.getProxyObject(Query.class);
        proxyObject.query("luwb");
        // 该方法不能被代理，因定义为final，不能被代理类重写
        proxyObject.query2("luwb2");
    }

}
