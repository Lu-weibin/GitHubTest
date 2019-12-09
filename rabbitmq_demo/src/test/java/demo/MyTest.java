package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luwb on 2019/09/25.
 * rabbitMq 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqApplication.class)
public class MyTest {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	public void testSend() {
		rabbitTemplate.convertAndSend("itcast", "发红包啦");
	}

	@Test
	public void testSendFanout() {
		rabbitTemplate.convertAndSend("chuanzhi", "", "分列模式走起啦");
	}

	@Test
	public void testSendTopic1() {
		rabbitTemplate.convertAndSend("topictest", "goods.aaa", "主题模式");
	}

	@Test
	public void testSendTopic2() {
		rabbitTemplate.convertAndSend("topictest", "article.content.log", "主题模式");
	}

	@Test
	public void testSendTopic3() {
		rabbitTemplate.convertAndSend("topictest", "goods.log", "主题模式");
	}

	@Test
	public void test2Send() {
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "这是第一个消息");
		map.put("data", Arrays.asList("lu", "wei"));
		rabbitTemplate.convertAndSend("test", map);
	}

	@Test
	public void receive() {
		Object object = rabbitTemplate.receiveAndConvert("test");
		System.out.println(object);
		System.out.println(object.getClass());
	}
}
