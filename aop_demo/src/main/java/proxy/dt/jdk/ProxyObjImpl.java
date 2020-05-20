package proxy.dt.jdk;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by luwb on 2020/05/06.
 * 被代理类
 */
public class ProxyObjImpl implements ProxyObj {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        System.out.println("set name=" + name);
    }

    @Override
    public void setAge(Integer age) {
        System.out.println("set age=" + age);
    }

}
