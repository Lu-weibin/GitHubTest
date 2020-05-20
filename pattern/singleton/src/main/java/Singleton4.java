/**
 * Created by luwb on 2020/05/19.
 *
 * 单例设计模式-静态内部类
 */
public class Singleton4 {

    public static class SingletonHolder{
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4(){}

    public static Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton4 instance1 = Singleton4.getInstance();
        Singleton4 instance2 = Singleton4.getInstance();
        System.out.println(instance1 == instance2);
    }

}
