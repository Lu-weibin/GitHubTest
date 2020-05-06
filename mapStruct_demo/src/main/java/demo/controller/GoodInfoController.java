package demo.controller;

import demo.dto.GoodInfoDTO;
import demo.mapper.GoodInfoMapper;
import demo.pojo.GoodInfoBean;
import demo.pojo.GoodTypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luwb on 2019/11/21.
 * 控制器
 */
@RestController
public class GoodInfoController {

	@Autowired
	private GoodInfoMapper goodInfoMapper;

	@RequestMapping(value = "/detail/{id}")
	public GoodInfoDTO detail(@PathVariable Long id) {
		//商品基本信息
		Long typeId = 5L;
		GoodInfoBean goodInfoBean = new GoodInfoBean(id, "haha", 110.1, 21, typeId);
		//商品类型信息
		GoodTypeBean goodTypeBean = new GoodTypeBean(typeId, "hehehe", 1, 22);
		return goodInfoMapper.from(goodInfoBean, goodTypeBean);
	}

}
