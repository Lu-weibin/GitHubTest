package demo.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * Created by luwb on 2019/12/10.
 * 实现类
 */
@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {
	@Override
	public String hello(String message) {
		return "hello," + message;
	}
}
