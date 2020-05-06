package demo.mapper;

import demo.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by luwb on 2019/12/09.
 * 用户权限
 */
@Mapper
public interface UserPermissionMapper {
	List<Permission> findByUserName(String userName);
}
