package demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by luwb on 2019/12/04.
 * 拦截器配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	private final TimeInterceptor timeInterceptor;

	@Autowired
	public WebConfig(TimeInterceptor timeInterceptor) {
		this.timeInterceptor = timeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timeInterceptor);
	}
}
