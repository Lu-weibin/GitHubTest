package demo.pojo;

/**
 * Created by luwb on 2020/05/20.
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
