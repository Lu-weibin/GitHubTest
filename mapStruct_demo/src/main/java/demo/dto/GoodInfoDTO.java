package demo.dto;

import lombok.Data;

/**
 * Created by luwb on 2019/11/21.
 * 自定义dto
 */
@Data
public class GoodInfoDTO {
	//商品编号
	private String goodId;
	//商品名称
	private String goodName;
	//商品价格
	private double goodPrice;
	//类型名称
	private String typeName;
}
