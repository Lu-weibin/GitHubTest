package demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by luwb on 2019/09/25.
 */
@Component
@RabbitListener(queues = "itheima")
public class Customer2 {
	@RabbitHandler
	public void showMessage(String message){
		System.out.println("itheima接收到的消息： "+message);
	}
}
