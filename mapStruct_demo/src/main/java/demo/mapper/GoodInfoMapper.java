package demo.mapper;

import demo.dto.GoodInfoDTO;
import demo.pojo.GoodInfoBean;
import demo.pojo.GoodTypeBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Created by luwb on 2019/11/21.
 * 配置映射
 */
@Mapper(componentModel = "spring")
public interface GoodInfoMapper {
	@Mappings({
			@Mapping(source = "type.name",target = "typeName"),
			@Mapping(source = "good.id",target = "goodId"),
			@Mapping(source = "good.title",target = "goodName"),
			@Mapping(source = "good.price",target = "goodPrice")
	})
	public GoodInfoDTO from(GoodInfoBean good, GoodTypeBean type);
}
