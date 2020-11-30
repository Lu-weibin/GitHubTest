package demo.anno;

import java.lang.annotation.*;

/**
 * @author luwb
 * @date 2019/12/12
 * 自定义注解
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface JDBCConfig {

	String ip();
	int port() default 3306;
	String database();
	String encoding();
	String loginName();
	String password();

}
