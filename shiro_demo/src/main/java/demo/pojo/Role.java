package demo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by luwb on 2019/12/09.
 * 角色实体
 */
@Data
@ToString
public class Role implements Serializable {
	private Integer id;
	private String name;
	private String memo;
}
