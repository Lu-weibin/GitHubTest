package proxy.dt.cglib;

/**
 * Created by luwb on 2020/05/06.
 * 被代理类
 */
public class Query {

    public boolean query(String name) {
        System.out.println("Query query " + name);
        return true;
    }

    /**
     * cglib代理通过继承被代理类，所有final方法不能被重写，所以定义的final方法不能被代理
     */
    public final boolean query2(String name) {
        System.out.println("Query query2 " + name);
        return true;
    }

}
