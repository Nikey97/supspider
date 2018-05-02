package cn.supspider.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.supspider.Utils.UtilMethods;
import cn.supspider.bean.userinfo;

	
@SuppressWarnings("serial")
@Transactional
public class user extends ActionSupport implements ModelDriven<userinfo>{
	//注入用户bean
	private userinfo userinfo;
	public void setUserinfo(userinfo userinfo) {
		this.userinfo = userinfo;
	}
	//注入工具
	private UtilMethods utilMethods;
	public void setUtilMethods(UtilMethods utilMethods) {
		this.utilMethods = utilMethods;
	}
	//注入hibernate模板
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//获取response对象
	ActionContext context=ActionContext.getContext();
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request=ServletActionContext.getRequest();
	
	//重写接口中的方法
	@Override
	public userinfo getModel() {
		// TODO Auto-generated method stub
		return userinfo;
	}
	//用户注册操作
	public String SignUp() throws IOException {
		userinfo.setActive(0);
		userinfo.setSignInTime(utilMethods.getNowSystemTime());
		userinfo.setSignUpTime(utilMethods.getNowSystemTime());
		hibernateTemplate.save(userinfo);
		//发送邮件
		return SUCCESS;
	}
	//用户登录操作
	@SuppressWarnings("unchecked")
	public String SignIn() throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		@SuppressWarnings("unused")
		List<userinfo> list=(List<cn.supspider.bean.userinfo>) hibernateTemplate.find("from userinfo where Email=? and PassWord=?", userinfo.getEmail(),userinfo.getPassWord());
		if(!list.isEmpty()) {
			//登录成功!
			out.print(1);
			context.getSession().put("userId", userinfo.getId());//向session中保存登录记录
			System.out.println("对"+"++"+userinfo.getEmail()+"+++"+userinfo.getPassWord());
		}else {
			//邮箱或密码错误
			out.print(0);
			System.out.println("错"+"++"+userinfo.getEmail()+"+++"+userinfo.getPassWord());
		}
		return NONE;
	}
	
	
	
	
	
}
