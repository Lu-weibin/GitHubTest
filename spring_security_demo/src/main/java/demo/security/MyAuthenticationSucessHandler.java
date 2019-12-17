package demo.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by luwb on 2019/12/17.
 * 成功返回结果
 */
@Component
public class MyAuthenticationSucessHandler implements AuthenticationSuccessHandler {

	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Autowired
	private ObjectMapper mapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		// 返回用户权限及账号信息
//		response.setContentType("application/json;charset=utf-8");
//		response.getWriter().write(mapper.writeValueAsString(authentication));
		// 跳回引发跳转的页面
//		SavedRequest savedRequest = requestCache.getRequest(request, response);
//		redirectStrategy.sendRedirect(request, response, savedRequest.getRedirectUrl());
		// 跳转到指定页面
		redirectStrategy.sendRedirect(request, response, "/index");
	}
}
