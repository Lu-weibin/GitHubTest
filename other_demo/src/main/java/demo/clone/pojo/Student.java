package demo.clone.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by luwb on 2019/12/17.
 * 学生实体
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Cloneable{
	private int age;
	private String name;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
