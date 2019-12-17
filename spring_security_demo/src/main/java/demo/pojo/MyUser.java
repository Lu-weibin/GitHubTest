package demo.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 模拟用户信息
 * Created by luwb on 2019/12/17.
 * User实体
 */
@Data
@ToString
public class MyUser implements Serializable {

	private String userName;

	private String password;

	private boolean accountNonExpired = true;

	private boolean accountNonLocked= true;

	private boolean credentialsNonExpired= true;

	private boolean enabled= true;
}
