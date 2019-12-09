package demo.listener;

import demo.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luwb on 2019/09/25.
 */
@Component
@RabbitListener(queues = "itcast")
public class Customer1 {
	@RabbitHandler
	public void showMessage(String message){
		System.out.println("itcast接收的消息 "+message);
	}
}
