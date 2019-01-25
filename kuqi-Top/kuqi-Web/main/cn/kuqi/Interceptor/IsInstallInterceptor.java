package cn.kuqi.Interceptor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import cn.kuqi.Annotation.IsInstall;
import test.PropertyTest;

public class IsInstallInterceptor implements HandlerInterceptor{
	
	private static final Logger logger = Logger.getLogger(IsInstallInterceptor.class); 
	
	/**
	 *       执行接口判断/kuqi-Dao/src/main/resources/db.properties是否为空
	* 
	 * 创建人：Nikey
	 * 创建时间：2018年11月15日 下午3:53:54  
	 * 创建功能：拦截一切的接口，检查那个接口加了相应的注解。再做对应的操作
	 * 创建备注：在处理器映射器之后适配器执行之前执行该方法
	 * @version
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean pass = true;
		Properties properties = new Properties();
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			IsInstall isInstall = handlerMethod.getMethod().getAnnotation(IsInstall.class);
			if (isInstall != null) {
				ClassLoader classLoader = IsInstallInterceptor.class.getClassLoader();
				InputStream is = classLoader.getResourceAsStream("db.properties");
				properties.load(is);
				String user = properties.getProperty("jdbc.user");
				String psw = properties.getProperty("jdbc.psw");
				if (user == null && psw == null) {
					pass = false;
					response.sendRedirect("");//重定向到安装页面
				}
			}
		}
		return pass;
	}
	
	/**
	 * 创建人：Nikey
	 * 创建时间：2018年11月15日 下午3:53:54  
	 * 创建功能：拦截一切的接口，检查那个接口加了相应的注解。再做对应的操作
	 * 创建备注：在适配器执行之后返回视图之前执行该方法
	 * @version
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws IOException, ServletException{
	}
	
	/**
	 * 创建人：Nikey
	 * 创建时间：2018年11月15日 下午3:53:54
	 * 创建功能：拦截一切的接口，检查那个接口加了相应的注解。再做对应的操作
	 * 创建备注：在返回视图之后执行用于清理工作
	 * @version
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
