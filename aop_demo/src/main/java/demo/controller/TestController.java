package demo.controller;

import demo.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luwb on 2020/01/09.
 * 测试控制器
 */
@RestController
public class TestController {

	@Log("执行方法一")
	@GetMapping("/one")
	public void methodOne(String name) {
		System.out.println("执行方法一");
	}

	@Log("执行方法二")
	@GetMapping("/two")
	public void methodTwo() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("执行方法二");
	}

	@Log("执行方法三")
	@GetMapping("/three")
	public void methodThree(String name, String age) {
		System.out.println("执行方法三");
	}
}
