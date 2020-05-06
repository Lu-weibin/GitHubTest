package proxy.jt;

/**
 * Created by luwb on 2020/05/06.
 * 代理类
 */
public class UserDaoProxy implements UserDao {

    private UserDaoImpl concreteUserDao;

    public UserDaoProxy() {}

    public UserDaoProxy(UserDaoImpl concreteUserDao) {
        this.concreteUserDao = concreteUserDao;
    }

    @Override
    public boolean insert(String name, int age) {
        System.out.println("before insert handle some logic");
        return concreteUserDao.insert(name, age);
    }
}
