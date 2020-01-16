package demo.thread;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Created by luwb on 2020/01/09.
 * ThreadLocal使用例子
 */
public class ThreadLocalExample implements Runnable {

	// SimpleDateFormat非线程安全，所以每个线程都要有自己的独立副本
	private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HH:mm"));
	// 不使用ThreadLoacl
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm");

	public static void main(String[] args) throws InterruptedException {
		ThreadLocalExample obj = new ThreadLocalExample();
		for (int i = 0; i < 10; i++) {
			// 使用ThreadLoacl
//			Thread t = new Thread(obj, "" + i);
			// 不使用ThreadLoacl
			Thread t = new Thread(new SimpleDateFormatRunnable(), "" + i);
			Thread.sleep(new Random().nextInt(1000));
			t.start();
		}
	}

	@Override
	public void run() {
		System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern());
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//formatter pattern is changed here by thread, but it won't reflect to other threads
		formatter.set(new SimpleDateFormat());
		System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
	}

	static class SimpleDateFormatRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("Thread Name= " + Thread.currentThread().getName() + " default SimpleDateFormat = " + sdf.toPattern());
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sdf = new SimpleDateFormat();
			System.out.println("Thread Name= "+Thread.currentThread().getName()+" SimpleDateFormat = "+sdf.toPattern());
		}
	}
}
