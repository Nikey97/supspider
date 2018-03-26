package cn.supspider.action;

import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.supspider.DbUtil.DBUtil;
import cn.supspider.bean.userbean;

public class ad extends ActionSupport implements ModelDriven<userbean>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 该action用于管理员登录:
	 * 
	 * 		
	 * 
	 * 
	 * */
	private userbean bean=new userbean();
			DBUtil db=new DBUtil();
			
	public userbean getBean() {
		return bean;
	}

	public void setBean(userbean bean) {
		this.bean = bean;
	}
	
	public String execute() throws Exception {
		ActionContext context=ActionContext.getContext();
		String sql="select * from manageinfo where name='"+bean.getName()+"' and password='"+bean.getPassword()+"';";//管理员登录校验
		ResultSet set=db.DBQuery(sql);
		if(set.next()) {
			context.getSession().put("username", bean.getName());
			return "success";
			//当用户名和密码都正确执行此处
		}else {
			return "failed";
			//登录失败执行此处
		}
	}
	
	public String exit() {
		return "exit";
	}
	
	@Override
	public userbean getModel() {
		// TODO Auto-generated method stub
		return bean;
	}
}
