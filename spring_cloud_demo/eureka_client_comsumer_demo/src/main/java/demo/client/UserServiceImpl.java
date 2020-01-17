package demo.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luwb on 2020/01/17.
 */
@Component
public class UserServiceImpl implements UserService {
	@Override
	public Map getUser(@PathVariable("name") String name) {
		Map<String, String> map = new HashMap<>();
		map.put("name", "default");
		return map;
	}
}
