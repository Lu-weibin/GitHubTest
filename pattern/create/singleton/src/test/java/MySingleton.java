/**
 * @author luwb
 * @date 2020/11/02
 */
public class MySingleton {

    /*

    // 方式一：饿汉式，立即加载，线程安全
    private static MySingleton mySingleton = new MySingleton();

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        return mySingleton;
    }
    */

/*
    // 方式二：懒汉式，延迟加载，加锁效率低
    private static MySingleton mySingleton;

    private MySingleton() {
    }

    public synchronized static MySingleton getInstance() {
        if (mySingleton == null) {
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }
    */

/*
    // 方式三：双重检查锁
    private volatile static MySingleton mySingleton;

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        if (mySingleton == null) {
            synchronized (MySingleton.class) {
                if (mySingleton == null) {
                    mySingleton = new MySingleton();
                }
            }
        }
        return mySingleton;
    }*/


    // 方式四：静态内部类
    public static class SingletonHolder {
        private final static MySingleton INSTANCE = new MySingleton();
    }

    public static MySingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
