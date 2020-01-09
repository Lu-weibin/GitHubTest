package demo.aspect;

import demo.annotation.Log;
import demo.pojo.SysLog;
import demo.util.HttpContextUtils;
import demo.util.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by luwb on 2020/01/09.
 * 切面类
 */
@Aspect
@Component
public class LogAspect {

	@Pointcut("@annotation(demo.annotation.Log))")
	public void pointcut() {
	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint point) {
		Object result = null;
		long beginTime = System.currentTimeMillis();
		try {
			result = point.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		long time = System.currentTimeMillis() - beginTime;
		// 打印日志信息
		print(point, time);
		return result;
	}

	private void print(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SysLog sysLog = new SysLog();
		Log logAnnotation = method.getAnnotation(Log.class);
		if (logAnnotation != null) {
			// 注解上的描述
			sysLog.setOperation(logAnnotation.value());
		}
		// 请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");
		// 请求的方法参数值
		Object[] args = joinPoint.getArgs();
		// 请求的方法参数名称
		LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
		String[] parameterNames = u.getParameterNames(method);
		if (args != null && parameterNames != null) {
			String params = "";
			for (int i = 0; i < args.length; i++) {
				params += " " + parameterNames[i] + ": " + args[i];
			}
			sysLog.setParams(params);
		}
		// 获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		// 设置IP地址
		sysLog.setIp(IPUtils.getIpAddr(request));
		// 模拟一个用户名
		sysLog.setUsername("luwb");
		sysLog.setTime((int) time);
		sysLog.setCreateTime(new Date());
		System.out.println(sysLog);
	}

}
