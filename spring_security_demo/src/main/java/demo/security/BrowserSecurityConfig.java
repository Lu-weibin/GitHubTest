package demo.security;

import demo.session.MySessionExpiredStrategy;
import demo.validate.code.ValidateCodeFilter;
import demo.validate.smscode.SmsAuthenticationConfig;
import demo.validate.smscode.SmsCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import javax.sql.DataSource;

/**
 * Created by luwb on 2019/12/17.
 * 配置类
 */
@Configuration
// 启用授权注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyAuthenticationSucessHandler authenticationSucessHandler;
	@Autowired
	private MyAuthenticationFailureHandler authenticationFailureHandler;
	@Autowired
	private ValidateCodeFilter validateCodeFilter;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private MyUserDetailService userDetailsService;
	@Autowired
	private SmsCodeFilter smsCodeFilter;
	@Autowired
	private SmsAuthenticationConfig smsAuthenticationConfig;
	@Autowired
	private MySessionExpiredStrategy sessionExpiredStrategy;
	@Autowired
	private MyAuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.httpBasic() // HTTP Basic方式
		http.exceptionHandling()
				.accessDeniedHandler(authenticationAccessDeniedHandler) // 处理无权限
				.and()
				.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加验证码校验过滤器
				.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加短信验证码校验过滤器
				.formLogin() // 表单方式
				.loginPage("/authentication/require") // 登录跳转 URL
				.loginProcessingUrl("/login") // 登录处理
				.successHandler(authenticationSucessHandler) // 处理登录成功
				.failureHandler(authenticationFailureHandler) // 处理登录失败
				.and()
				.rememberMe()
				.tokenRepository(persistentTokenRepository()) // 配置token持久化仓库
				.tokenValiditySeconds(3600) //  remember 过期时间，单位为秒
				.userDetailsService(userDetailsService) // 处理自动登录逻辑
				.and()
				.authorizeRequests() // 授权配置
				.antMatchers("/authentication/require", "/login.html", "/css/**", "/code/image", "/code/sms",
						"/session/invalid","/signout/success").permitAll() //无需认证
				.anyRequest() // 所有请求
				.authenticated() // 都需要认证
				.and()
				.sessionManagement() // 添加Session管理器
				.invalidSessionUrl("/session/invalid") // Session失效后跳转的url
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true)
				.expiredSessionStrategy(sessionExpiredStrategy)
				.and().and()
				.logout()
				.logoutUrl("/signout")
				 .logoutSuccessUrl("/signout/success")
				.deleteCookies("JSESSIONID")
				.and()
				.csrf().disable()
				.apply(smsAuthenticationConfig); // 将短信验证码认证配置加到Spring Security中
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
		jdbcTokenRepository.setDataSource(dataSource);
		jdbcTokenRepository.setCreateTableOnStartup(false);
		return jdbcTokenRepository;
	}
}
