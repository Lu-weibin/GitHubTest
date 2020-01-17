package demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

/**
 * Created by luwb on 2020/01/16.
 */
//@FeignClient("eureka-client-provide-demo")
//使用hystrix,当提供的服务挂了的时候可以调用UserServiceImpl中的方法返回
@FeignClient(value = "eureka-client-provide-demo",fallback = UserServiceImpl.class)
public interface UserService {

	@RequestMapping("user/{name}")
	Map getUser(@PathVariable("name") String name);

}
