package demo.lambda.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * Created by luwb on 2019/12/12.
 * 实体类
 */
@Data
@ToString
public class Hero {
	private String name;
	private float hp;
	private int damage;
	private int id;
}
