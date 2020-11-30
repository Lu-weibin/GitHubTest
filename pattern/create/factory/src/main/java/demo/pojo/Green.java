package demo.pojo;

/**
 * Created by luwb on 2020/05/20.
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
