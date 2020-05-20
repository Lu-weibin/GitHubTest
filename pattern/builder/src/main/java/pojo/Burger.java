package pojo;

/**
 * Created by luwb on 2020/05/20.
 */
public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
