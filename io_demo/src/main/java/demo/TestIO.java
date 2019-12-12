package demo;

import org.springframework.util.ResourceUtils;
import java.io.*;

/**
 * Created by luwb on 2019/12/12.
 * io操作
 */
public class TestIO {

	public static void main(String[] args) throws IOException {
		// File中的常用方法
		method1();
		// finally中关闭流
		method2();
		// try-with-resources 方式关闭流
		method3();

	}

	private static void method1() throws IOException {
		// 获取绝对路径
		File file = new File("D:\\Git_project\\MyDemo\\io_demo\\src\\main\\resources\\test.txt");
		System.out.println(file.getAbsolutePath());
		// 文件是否存在、是否文件夹/文件、文件长度、文件最后修改时间、文件重命名
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.length());
		System.out.println(file.lastModified());
		File file2 = new File("D:\\Git_project\\MyDemo\\io_demo\\src\\main\\resources\\test2.txt");
		System.out.println(file.renameTo(file2));
		// 文件夹下所有的文件（String）
		file.list();
		// 文件夹下所有文件（File）
		file.listFiles();
		// 所在文件夹(String)
		file.getParent();
		// 所在文件夹（File）
		file.getParentFile();
		// 创建目录
		file.mkdirs();
		// 建新文件
		file.createNewFile();
		// 建新文件前，先建父目录
		file.getParentFile().mkdirs();
		// 删除文件
		file.delete();
	}

	private static void method2() {
		FileInputStream fis = null;
		try {
			File file = ResourceUtils.getFile("classpath:test.txt");
			// 创建基于文件的输出流
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void method3() throws IOException {
		File file = ResourceUtils.getFile("classpath:test.txt");
		try (FileReader fr = new FileReader(file)) {
			char[] all = new char[(int) file.length()];
			fr.read(all);
			for (char c : all) {
				System.out.println(c);
			}
		}
	}

}
