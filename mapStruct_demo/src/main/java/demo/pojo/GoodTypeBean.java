package demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by luwb on 2019/11/21.
 * 商品类型实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodTypeBean {
	private Long id;
	private String name;
	private int show;
	private int order;
}
