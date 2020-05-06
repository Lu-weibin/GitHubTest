package demo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import java.io.*;

/**
 * Created by luwb on 2019/12/12.
 * io操作
 */
public class TestIO {

	public static void main(String[] args) throws IOException {
		// finally中关闭流
//		method1();
		// try-with-resources 方式关闭流
//		method2();
		// 读取resource下的文件
//		method3();
		// 读取一个文件内容写入另一文件
		method4();

	}

	private static void method1() {
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

	private static void method2() throws IOException {
		File file = ResourceUtils.getFile("classpath:test.txt");
		try (FileReader fr = new FileReader(file)) {
			char[] all = new char[(int) file.length()];
			fr.read(all);
			for (char c : all) {
				System.out.println(c);
			}
		}
	}

	private static void method3() throws IOException {
		InputStream inputStream = new ClassPathResource("test2.txt").getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}

	private static void method4() {
		try (InputStream inputStream = new ClassPathResource("test2.txt").getInputStream();
			 BufferedInputStream bis = new BufferedInputStream(inputStream);
			 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D://temp/temp.txt"))) {
			byte[] buffer = new byte[1024 * 8];
			int len;
			while ((len = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
