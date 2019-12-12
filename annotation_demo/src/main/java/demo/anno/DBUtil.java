package demo.anno;

/**
 * Created by luwb on 2019/12/12.
 * 解析注解
 */
@JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "admin")
public class DBUtil {

	public static void main(String[] args) {
		String connection = getConnection();
		System.out.println(connection);
	}

	private static String getConnection() {
		// 获取注解中的信息
		JDBCConfig jdbcConfig = DBUtil.class.getAnnotation(JDBCConfig.class);
		return String.format(" ip:%s\n database:%s\n port:%d\n encoding:%s\n loginName:%s\n password:%s",
				jdbcConfig.ip(), jdbcConfig.database(), jdbcConfig.port(), jdbcConfig.encoding(),
				jdbcConfig.loginName(), jdbcConfig.password());
	}
}
