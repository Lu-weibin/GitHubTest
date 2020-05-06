package demo.lambda.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;

/**
 * Created by luwb on 2019/12/12.
 * 实体类
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Hero implements Serializable,Comparable<Hero> {
	public String name;
	public float hp;
	public int damage;

	public Hero(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Hero o) {
		if (damage < o.getDamage()) {
			return 1;
		} else {
			return -1;
		}
	}
}
