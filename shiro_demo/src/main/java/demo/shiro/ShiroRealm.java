package demo.shiro;

import demo.mapper.UserMapper;
import demo.mapper.UserPermissionMapper;
import demo.mapper.UserRoleMapper;
import demo.lambda.pojo.Permission;
import demo.lambda.pojo.Role;
import demo.lambda.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by luwb on 2019/12/04.
 * Realm
 */
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private UserPermissionMapper userPermissionMapper;

	/**
	 * 获取用户角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		String userName = user.getUserName();

		System.out.println("用户" + userName + "获取权限-----ShiroRealm.doGetAuthorizationInfo");
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 获取用户角色集
		List<Role> roleList = userRoleMapper.findByUserName(userName);
		Set<String> roleSet = new HashSet<>();
		for (Role r : roleList) {
			roleSet.add(r.getName());
		}
		simpleAuthorizationInfo.setRoles(roleSet);
		// 获取用户权限集
		List<Permission> permissionList = userPermissionMapper.findByUserName(userName);
		Set<String> permissionSet = new HashSet<>();
		for (Permission p : permissionList) {
			permissionSet.add(p.getName());
		}
		simpleAuthorizationInfo.setStringPermissions(permissionSet);
		return simpleAuthorizationInfo;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		// 获取用户输入的用户名和密码
		String userName = (String) authenticationToken.getPrincipal();
		String password = new String((char[]) authenticationToken.getCredentials());
		System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
		User user = userMapper.findByUserName(userName);
		if (user == null) {
			throw new UnknownAccountException("用户名或密码错误！");
		}
		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("用户名或密码错误！");
		}
		if ("0".equals(user.getStatus())) {
			throw new LockedAccountException("账号已被锁定,请联系管理员！");
		}
		return new SimpleAuthenticationInfo(user, password, getName());
	}
}
