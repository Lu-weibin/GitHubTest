package demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by luwb on 2019/09/25.
 */
@Component
@RabbitListener(queues = "kudingyu")
public class Customer3 {
	@RabbitHandler
	public void showMessage(String message){
		System.out.println("kudingyu接收到的消息： "+message);
	}
}
