package cn.supspider.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	private String ToEmailaddress;
	public String getToEmailaddress() {
		return ToEmailaddress;
	}
	public void setToEmailaddress(String toEmailaddress) {
		ToEmailaddress = toEmailaddress;
	}
	public String SignUp() throws Exception {
		@SuppressWarnings("unchecked")
		List<userinfo> list = (List<cn.supspider.bean.userinfo>) hibernateTemplate.find("from userinfo where Email=?", userinfo.getEmail());
		if(!list.isEmpty()) {
			this.addActionError("该邮箱已注册,请换一个注册"); 
			return INPUT;
		}else {
			userinfo.setActive(0);
			userinfo.setSignInTime(utilMethods.getNowSystemTime());
			userinfo.setSignUpTime(utilMethods.getNowSystemTime());
			userinfo.setCode(utilMethods.CreateSuperCode());//写入邮件验证码
			hibernateTemplate.save(userinfo);//持久化到数据库
			//发送邮件
			utilMethods.Send(userinfo.getEmail(), userinfo.getCode(),userinfo.getId());
			ToEmailaddress=utilMethods.FindEmailContext(userinfo.getEmail());
			System.out.println(ToEmailaddress);
		}
		return SUCCESS;
	}
	//用户登录操作
	@SuppressWarnings("unchecked")
	public String SignIn() throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		System.out.println("邮箱:"+userinfo.getEmail()+"|"+"密码"+userinfo.getPassWord());
		return NONE;
	}
	//邮箱注册响应校验
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@SuppressWarnings("unchecked")
	public String SignUpCheckout() throws ParseException {
		@SuppressWarnings("unused")
		List<userinfo> list = (List<cn.supspider.bean.userinfo>) hibernateTemplate.find("from userinfo where id=? and code=? and active=?", userinfo.getId(),userinfo.getCode(),0);
		if(!list.isEmpty()) {
			for (userinfo userinfo : list) {
				String NowDate=utilMethods.getNowSystemTime();
				String SignUpDate=userinfo.getSignUpTime();
				Date DateNow=df.parse(NowDate);
				Date DateSignUp=df.parse(SignUpDate);
				long s=(DateNow.getTime()-DateSignUp.getTime())/1000;
				int m=(int) (s/60);
				if(m<=30) {
					//激活成功
					userinfo.setId(userinfo.getId());
					userinfo.setActive(1);
					hibernateTemplate.saveOrUpdate(userinfo);
					return SUCCESS;
				}else {
					//激活失败
					this.addActionError("很抱歉,您没有在指定时间内激活账号.请重新注册!");
					return INPUT;
				}
			}
		}else {
			this.addActionError("激活账号异常:1.该账号不存在 2.该账号已经激活");
			return INPUT;
		}
		return NONE;
	}
	
	
	
	
}
