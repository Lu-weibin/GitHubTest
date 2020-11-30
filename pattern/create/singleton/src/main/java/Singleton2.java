/**
 * Created by luwb on 2020/05/19.
 *
 * 单例设计模式-懒汉式
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {}

    /**
     * 非线程安全
     */
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

    /**
     * 线程安全，但效率低
     */
    public static synchronized Singleton2 getInstance2() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        System.out.println(instance == instance2);

        Singleton2 instance3 = Singleton2.getInstance2();
        Singleton2 instance4 = Singleton2.getInstance2();
        System.out.println(instance3 == instance4);
    }

}
