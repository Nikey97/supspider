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
	 * ��action���ڹ���Ա��¼:
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
		String sql="select * from manageinfo where name='"+bean.getName()+"' and password='"+bean.getPassword()+"';";//����Ա��¼У��
		ResultSet set=db.DBQuery(sql);
		if(set.next()) {
			context.getSession().put("username", bean.getName());
			return "success";
			//���û��������붼��ȷִ�д˴�
		}else {
			return "failed";
			//��¼ʧ��ִ�д˴�
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
