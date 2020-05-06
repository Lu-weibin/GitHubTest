package demo.pojo;

import ch.qos.logback.classic.net.SyslogAppender;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by luwb on 2020/01/09.
 * 实体
 */
@Data
public class SysLog implements Serializable {

	private static final long serialVersionUID = -6309732882044872298L;

	private Integer id;
	private String username;
	private String operation;
	private Integer time;
	private String method;
	private String params;
	private String ip;
	private Date createTime;

}
