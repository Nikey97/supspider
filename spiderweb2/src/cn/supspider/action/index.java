package cn.supspider.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cn.supspider.bean.ResourceAll;
import cn.supspider.bean.ad_allWebinfo;

@SuppressWarnings("serial")
@Transactional
public class index extends ActionSupport implements ModelDriven<ad_allWebinfo>{
		//访问首页数据回显的操作
						/*步奏:
						 * 		1.将数据查出来
						 * 		2.在将对应的存入值栈中
						 * 		3.再在页面中取出来显示
						 * */
		//注入相应的框架模板
		private HibernateTemplate hibernateTemplate;
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		
		//注入网站所有信息表
		private ad_allWebinfo ad_allWebinfo;
		public void setAd_allWebinfo(ad_allWebinfo ad_allWebinfo) {
			this.ad_allWebinfo = ad_allWebinfo;
		}
		public ad_allWebinfo getAd_allWebinfo() {
			return ad_allWebinfo;
		}
		//实例化相应的request的Api
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		
		//实例化注入资源仓库
		private ResourceAll resourceAll;
		public void setResourceAll(ResourceAll resourceAll) {
			this.resourceAll = resourceAll;
		}
		public ResourceAll getResourceAll() {
			return resourceAll;
		}
		//为向值栈中存入用户信息,用于前台验证登录等操作
		private String username;
		public String getUsername() {
			return username;
		}
		//
		public String execute() throws Exception {
			ValueStack stack=ActionContext.getContext().getValueStack();
			@SuppressWarnings({ "unchecked", "unused" })
			//网站信息查询
			List<ad_allWebinfo> list=(List<ad_allWebinfo>) hibernateTemplate.find("from ad_allWebinfo where number=?", 1);//1.
			for (ad_allWebinfo ad : list) {
				ad_allWebinfo.setWeb_Name(ad.getWeb_Name());
				ad_allWebinfo.setWeb_Keyword(ad.getWeb_Keyword());
				ad_allWebinfo.setWeb_Introduce(ad.getWeb_Introduce());
			}//2.向值栈中存储数据
			
			//热搜
			
			//最新资源
			hibernateTemplate.setMaxResults(8);
			@SuppressWarnings("unchecked")
			List<ResourceAll> MusicList = (List<ResourceAll>) hibernateTemplate.find("from ResourceAll where R_type=?","1");
			stack.set("MusicList", MusicList);
			@SuppressWarnings("unchecked")
			List<ResourceAll> MovieList = (List<ResourceAll>) hibernateTemplate.find("from ResourceAll where R_type=?","0");
			stack.set("MovieList", MovieList);
			@SuppressWarnings("unchecked")
			List<ResourceAll> OtherList = (List<ResourceAll>) hibernateTemplate.find("from ResourceAll where R_type=?","2");
			stack.set("OtherList", OtherList);
			//判断用户是否登录,返回到页面
			HttpSession session = request.getSession();
			if(session.getAttribute("user_name")!=null) {
				username=(String) session.getAttribute("user_name");
			}
			return SUCCESS;
		}
		@Override
		public ad_allWebinfo getModel() {
			// TODO Auto-generated method stub
			return ad_allWebinfo;
		}
}
