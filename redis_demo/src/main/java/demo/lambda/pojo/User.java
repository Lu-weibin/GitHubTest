package demo.lambda.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;

/**
 * Created by luwb on 2019/12/03.
 * 用户实体类
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	private String id;
	private String name;
	private Integer age;
}
