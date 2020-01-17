package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by luwb on 2020/01/16.
 * 注册到eureka 提供服务或消费
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientProvideApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientProvideApplication.class, args);
	}
}
