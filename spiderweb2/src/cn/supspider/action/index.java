package cn.supspider.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cn.supspider.bean.Movie;
import cn.supspider.bean.Music;
import cn.supspider.bean.Other;
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
		//获取值栈
		ValueStack stack = context.getValueStack();
		
		//实例化注入Movie
		private Movie movie;
		public void setMovie(Movie movie) {
			this.movie = movie;
		}
		public Movie getMovie() {
			return movie;
		}
		
		
		public String execute() throws Exception {
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
			ValueStack stack = ActionContext.getContext().getValueStack();
			@SuppressWarnings({ "unchecked", "unused" })
			List<Movie> list2= (List<Movie>) hibernateTemplate.find("from Movie");
			stack.set("MovieList", list2);
			List<Music> list3 = (List<Music>) hibernateTemplate.find("from Music");
			stack.set("MusicList", list3);
			List<Other> list4 = (List<Other>) hibernateTemplate.find("from Other");
			stack.set("OtherList", list4);
			return SUCCESS;
		}


		@Override
		public ad_allWebinfo getModel() {
			// TODO Auto-generated method stub
			return ad_allWebinfo;
		}
}
