package cn.supspider.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.supspider.Utils.HibernateUtil;
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
			
	public userbean getBean() {
		return bean;
	}

	public void setBean(userbean bean) {
		this.bean = bean;
	}
	
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	Session session=sessionFactory.openSession();
	Transaction t=session.beginTransaction();

	public String execute() throws Exception {
		
		//登录校验业务逻辑
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession pagesession=request.getSession();
		try {
			Query query=session.createQuery("from userbean where name=? and password=?");
			query.setParameter(0, bean.getName());
			query.setParameter(1, bean.getPassword());
			List<userbean> list=query.list();
			if(list.size()>0) {
				pagesession.setAttribute("username", bean.getName());//向页面session域对象中存储用户信息
				return "success";
			}
			t.commit();//提交事务
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			t.rollback();//事务回滚
		}finally {
			session.close();
			sessionFactory.close();
		}
		return "failed";
	}
	
	public String exit() {
		//注销登录操作
		System.out.println("exit执行......");
		return "exit";
	}
	
	@Override
	public userbean getModel() {
		// TODO Auto-generated method stub
		return bean;
	}
}
