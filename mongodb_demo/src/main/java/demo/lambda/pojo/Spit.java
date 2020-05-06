package demo.lambda.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by luwb on 2019/12/02.
 * Spit实体
 */
@Data
@ToString
public class Spit implements Serializable {
	@Id
	private String _id;
	private String content;
	private Date publishtime;
	private String userid;
	private String nickname;
	private Integer visits;
	private Integer thumbup;
	private Integer share;
	private Integer comment;
	private String state;
	private String parentid;
}
