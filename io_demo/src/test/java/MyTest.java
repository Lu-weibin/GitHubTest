import org.junit.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luwb on 2020/03/10.
 */
public class MyTest {

	@Test
	public void test1() throws IOException {
		Map<String, String> map = new HashMap<>(16);
		map.put(null, "hah");
		map.put(null, null);
		map.put("name", "luweibin");
		map.forEach((key, value) ->{
			System.out.println(key);
			System.out.println(value);
		});
	}

	@Test
	public void test2() {
		int byteToMb = 1024 * 1024;
		Runtime rt = Runtime.getRuntime();
		long vmTotal = rt.totalMemory() / byteToMb;
		long vmFree = rt.freeMemory() / byteToMb;
		long vmMax = rt.maxMemory() / byteToMb;
		long vmUse = vmTotal - vmFree;
		System.out.format("JVM内存已用：%sMB;空闲：%sMB;总内存：%s MB;最大内存: %sMB", vmUse, vmFree, vmTotal, vmMax);
	}

}
