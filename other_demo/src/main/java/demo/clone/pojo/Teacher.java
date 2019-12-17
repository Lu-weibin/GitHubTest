package demo.clone.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by luwb on 2019/12/17.
 * 教师实体
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Cloneable {
	private Integer age;
	private String name;
	private Student student;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
