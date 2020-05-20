package demo.thread;


import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by luwb on 2020/05/19.
 */
public class ThreadDemo {

    public static void main(String[] args) {
        ThreadDemo main = new ThreadDemo();

        // 创建线程并启动
        Thread t = new Thread(main.runnable);
        System.out.println("This is main ");
        t.start();

        try {
            // 在 main线程睡个3秒钟
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("In main");
            e.printStackTrace();
        }

        // 设置中断
        t.interrupt();
    }

    Runnable runnable = () -> {
        int i = 0;
        try {
            while (i < 1000) {

                // 睡个半秒钟我们再执行
                Thread.sleep(500);

                System.out.println(i++);
            }
        } catch (InterruptedException e) {


            // 判断该阻塞线程是否还在
            System.out.println(Thread.currentThread().isAlive());

            // 判断该线程的中断标志位状态
            System.out.println(Thread.currentThread().isInterrupted());

            System.out.println("In Runnable");
            e.printStackTrace();
        }
    };

    public synchronized void test() {
        System.out.println("test");
    }

    public void test2() {
        ConcurrentHashMap map = new ConcurrentHashMap<>();
    }

}
