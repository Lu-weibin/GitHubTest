package demo.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author luwb
 * @date 2020/06/24
 */
public class ThreadPoolExecutorDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor myThreadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(50),
                new ThreadPoolExecutor.CallerRunsPolicy());

        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            MyCallable myRunnable = new MyCallable("command" + i);
            futures.add(myThreadPoolExecutor.submit(myRunnable));
        }
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        System.out.println("main");
        myThreadPoolExecutor.shutdown();
        System.out.println("Finished all threads");
    }


    private static class MyCallable implements Callable<String> {

        private String command;

        public MyCallable(String command) {
            this.command = command;
        }

        @Override
        public String call() {
            System.out.println(command + " Start. Time = " + new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date()));
            processCommand();
            System.out.println(command + " End. Time = " + new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date()));
            return "ok";
        }

        private void processCommand() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
