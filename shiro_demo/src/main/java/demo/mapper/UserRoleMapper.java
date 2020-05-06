package demo.mapper;

import demo.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * Created by luwb on 2019/12/09.
 * 用户角色持久层
 */
@Mapper
public interface UserRoleMapper {
	List<Role> findByUserName(String userName);
}
