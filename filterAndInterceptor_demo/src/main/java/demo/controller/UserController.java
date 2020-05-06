package demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luwb on 2019/12/04.
 * User控制器
 */
@RestController
@RequestMapping("user")
public class UserController {

	@GetMapping("/{id:\\d+}")
	public String get(@PathVariable String id) {
		System.out.println("controller中的方法执行" + id);
		return "ok";
	}
}
