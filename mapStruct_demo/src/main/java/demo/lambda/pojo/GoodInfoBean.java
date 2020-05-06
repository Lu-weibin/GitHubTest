package demo.lambda.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by luwb on 2019/11/21.
 * 商品基本信息实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodInfoBean {
	private Long id;
	private String title;
	private double price;
	private int order;
	private Long typeId;
}
