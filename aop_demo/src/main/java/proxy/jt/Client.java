package proxy.jt;

/**
 * Created by luwb on 2020/05/06.
 */
public class Client {

    public static void main(String[] args) {
        UserDaoImpl concreteUserDao = new UserDaoImpl();
        UserDaoProxy userDaoProxy = new UserDaoProxy(concreteUserDao);
        userDaoProxy.insert("luwb", 24);
    }

}
