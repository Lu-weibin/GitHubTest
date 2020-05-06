package demo.lambda.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by luwb on 2019/12/04.
 * 实体类
 */
@Data
@ToString
public class User implements Serializable {
	private Integer id;
	private String userName;
	private String password;
	private Date createTime;
	private String status;
}
