package demo.mapper;

import demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	User findByUserName(String userName);
}
