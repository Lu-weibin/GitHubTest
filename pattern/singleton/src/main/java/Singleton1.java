/**
 * Created by luwb on 2020/05/19.
 *
 * 单例设计模式-饿汉式
 */
public class Singleton1 {

    private static Singleton1 instance = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getSingleton() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton1 instance1 = Singleton1.getSingleton();
        Singleton1 instance2 = Singleton1.getSingleton();
        System.out.println(instance1 == instance2);
    }

}
