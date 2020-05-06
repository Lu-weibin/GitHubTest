package demo.service;

import demo.pojo.UserOnline;

import java.util.List;

/**
 * Created by luwb on 2019/12/10.
 */
public interface SessionService {
	List<UserOnline> list();
	boolean forceLogout(String sessionId);
}
