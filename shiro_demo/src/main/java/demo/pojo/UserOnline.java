package demo.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by luwb on 2019/12/10.
 * 实体类
 */
@Data
@ToString
public class UserOnline implements Serializable {
	// session id
	private String id;
	// 用户id
	private String userId;
	// 用户名称
	private String username;
	// 用户主机地址
	private String host;
	// 用户登录时系统IP
	private String systemHost;
	// 状态
	private String status;
	// session创建时间
	private Date startTimestamp;
	// session最后访问时间
	private Date lastAccessTime;
	// 超时时间
	private Long timeout;
}
