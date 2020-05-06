package demo.lambda.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by luwb on 2019/12/09.
 * 权限表
 */
@Data
@ToString
public class Permission implements Serializable {
	private Integer id;
	private String url;
	private String name;
}
