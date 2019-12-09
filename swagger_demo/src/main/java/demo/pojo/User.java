package demo.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by luwb on 2019/12/04.
 * User实体
 */
@Data
@ToString
public class User implements Serializable {
	private Long id;
	private String name;
	private Integer age;
}
