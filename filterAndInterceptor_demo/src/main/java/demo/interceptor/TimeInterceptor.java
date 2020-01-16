package demo.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luwb on 2019/12/04.
 * 拦截器
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("处理拦截之前");
		request.setAttribute("startTime", System.currentTimeMillis());
		System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
		System.out.println(((HandlerMethod) handler).getMethod().getName());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
		System.out.println("开始处理拦截");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("【拦截器】耗时 " + (System.currentTimeMillis() - start));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
		System.out.println("处理拦截之后");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("【拦截器】耗时 " + (System.currentTimeMillis() - start));
		System.out.println("异常信息 " + ex);
	}
}
