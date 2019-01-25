package cn.kuqi.Interceptor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import cn.kuqi.Annotation.CheckUserIdentity;

public class UserCheckIndentityInterceptor implements HandlerInterceptor{
	
	/**
	 * 创建人：Nikey
	 * 创建时间：2018年11月4日下午9:24:07
	 * 创建功能：拦截一切的接口，检查那个接口加了相应的注解。再做对应的操作
	 * 创建备注：在处理器映射器之后适配器执行之前执行该方法
	 * @version
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean pass = true;
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			CheckUserIdentity checkUserIdentity = handlerMethod.getMethod().getAnnotation(CheckUserIdentity.class);
			if (checkUserIdentity != null) {
				System.out.println("注释");
				HttpSession session = request.getSession();
				String username = (String) session.getAttribute("account");
				System.out.println("检测到用户："+username);
				if (username == null) {
					pass = false;
					response.sendRedirect(request.getContextPath()+"/admin/login");
				}else {
					pass = true;
				}
			}else {
				pass=true;
			}
		}
		return pass;
	}
	
	/**
	 * 创建人：Nikey
	 * 创建时间：2018年11月4日下午9:24:07
	 * 创建功能：拦截一切的接口，检查那个接口加了相应的注解。再做对应的操作
	 * 创建备注：在适配器执行之后返回视图之前执行该方法
	 * @version
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws IOException, ServletException{
	}
	
	/**
	 * 创建人：Nikey
	 * 创建时间：2018年11月4日下午9:24:07
	 * 创建功能：拦截一切的接口，检查那个接口加了相应的注解。再做对应的操作
	 * 创建备注：在返回视图之后执行用于清理工作
	 * @version
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
