package demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import demo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luwb on 2019/12/10.
 * TestController
 */
@RestController
public class TestController {
	@Reference
	private HelloService helloService;

	@GetMapping("/hello/{message}")
	public String hello(@PathVariable String message) {
		return this.helloService.hello(message);
	}
}
