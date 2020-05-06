package proxy.dt.jdk;

/**
 * Created by luwb on 2020/05/06.
 * 被代理类
 */
public class ProxyObjImpl implements ProxyObj {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAge(Integer age) {
        System.out.println("set age=" + age);
    }

}
