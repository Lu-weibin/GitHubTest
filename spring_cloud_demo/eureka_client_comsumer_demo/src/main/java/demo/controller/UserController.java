package demo.controller;

import demo.client.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * Created by luwb on 2020/01/16.
 */
@RequestMapping("user")
@RestController
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("getUser/{name}")
	public Map getUser(@PathVariable("name") String name) {
		return userService.getUser(name);
	}

	@RequestMapping("test")
	public String test() {
		return "ok";
	}

}
