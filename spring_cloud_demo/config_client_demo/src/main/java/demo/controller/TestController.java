package demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luwb on 2020/01/17.
 * 测试读取配置文件信息
 */
@RestController
@RefreshScope
public class TestController {

	@Value("${sms.ip}")
	private String sms;

	@GetMapping("sms")
	public String getInfo() {
		return sms;
	}
}
