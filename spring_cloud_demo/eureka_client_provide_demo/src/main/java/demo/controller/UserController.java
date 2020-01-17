package demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luwb on 2020/01/16.
 */
@RestController
public class UserController {

	@RequestMapping("user/{name}")
	public Map getUser(@PathVariable String name) {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		return map;
	}

}
