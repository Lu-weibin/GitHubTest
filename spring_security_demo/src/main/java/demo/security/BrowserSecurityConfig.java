package demo.security;

import demo.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by luwb on 2019/12/17.
 * 配置类
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyAuthenticationSucessHandler authenticationSucessHandler;
	@Autowired
	private MyAuthenticationFailureHandler authenticationFailureHandler;
	@Autowired
	private ValidateCodeFilter validateCodeFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.httpBasic() //HTTP Basic方式
		http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加验证码校验过滤器
				.formLogin() //表单方式
				.loginPage("/authentication/require")
				.loginProcessingUrl("/login")
				.successHandler(authenticationSucessHandler)
				.failureHandler(authenticationFailureHandler)
				.and()
				.authorizeRequests() // 授权配置
				.antMatchers("/authentication/require", "/login.html", "/css/**","/code/image").permitAll() //无需认证
				.anyRequest() // 所有请求
				.authenticated() // 都需要认证
				.and().csrf().disable();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
