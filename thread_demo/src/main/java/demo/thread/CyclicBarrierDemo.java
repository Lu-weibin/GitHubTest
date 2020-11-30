package demo.thread;

import java.util.concurrent.*;

/**
 * @author luwb
 * @date 2020/11/30
 */
public class CyclicBarrierDemo {

    /**
     * 请求的数量
     */
    private static final int THREAD_COUNT = 550;
    /**
     * 需要同步的线程数量
     */
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            Thread.sleep(100);
            threadPool.execute(() -> {
                test(threadNum);
            });
        }
        threadPool.shutdown();
    }

    private static void test(int threadNum) {
        System.out.println("threadNum:" + threadNum + "is ready");
        try {
            // 等待60秒，保证子线程完全执行结束
            cyclicBarrier.await(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println("threadNum:" + threadNum + "is finish");
    }

}
