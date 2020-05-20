/**
 * Created by luwb on 2020/05/19.
 *
 * 单例设计模式-双重校验锁
 */
public class Singleton3 {

    /**
     * volatile 防止指令重排序
     */
    private volatile static Singleton3 instance;

    private Singleton3(){}

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton3 instance1 = Singleton3.getInstance();
        Singleton3 instance2 = Singleton3.getInstance();
        System.out.println(instance1 == instance2);
    }

}
