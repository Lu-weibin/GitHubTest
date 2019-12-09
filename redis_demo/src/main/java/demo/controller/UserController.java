package demo.controller;

import demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * Created by luwb on 2019/12/03.
 * 控制器
 */
@RequestMapping("user")
@RestController
public class UserController {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@RequestMapping(value = "add",method = RequestMethod.POST)
	public void add(@RequestBody User user) {
		redisTemplate.opsForValue().set("user_"+user.getId(),user);
	}

	@RequestMapping(value = "/{id}")
	public User findOne(@PathVariable String id) {
		return (User) redisTemplate.opsForValue().get("user_" + id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable String id) {
		return redisTemplate.delete("user_"+id);
	}
}
