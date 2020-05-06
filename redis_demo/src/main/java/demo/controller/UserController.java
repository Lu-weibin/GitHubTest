package demo.controller;

import demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by luwb on 2019/12/03.
 * 控制器
 */
@RequestMapping("user")
@RestController
public class UserController {

	private final RedisTemplate<String, Object> redisTemplate;

	@Autowired
	public UserController(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@RequestMapping(value = "add")
	public User add() {
		Random random = new Random();
		int id = random.nextInt(1000);
		User user = new User(""+id,"name"+id,23);
		redisTemplate.opsForValue().set("user_"+user.getId(),user);
		return user;
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
