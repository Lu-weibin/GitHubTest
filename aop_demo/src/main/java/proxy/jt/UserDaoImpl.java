package proxy.jt;

/**
 * Created by luwb on 2020/05/06.
 * 被代理类
 */
public class UserDaoImpl implements UserDao {

    @Override
    public boolean insert(String name, int age) {
        System.out.println("insert into database name=" + name + " age=" + age);
        return true;
    }

}
