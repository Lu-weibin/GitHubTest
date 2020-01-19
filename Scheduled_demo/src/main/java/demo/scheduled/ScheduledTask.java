package demo.scheduled;

import demo.pojo.User;
import demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by luwb on 2020/01/17.
 * 定时任务类
 */
@Component
@EnableScheduling
public class ScheduledTask {

	private final UserRepository userRepository;

	@Autowired
	public ScheduledTask(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Scheduled(cron = "1,11,21,31,41,51 * * * * *")
	public void print() {
		List<User> all = userRepository.findAll();
		System.out.println(all);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		System.out.println("--------------------------------");
	}
}
