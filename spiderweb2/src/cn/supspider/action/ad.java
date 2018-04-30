package cn.supspider.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.Id;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ServletConfigAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.supspider.Utils.ToJsonType;
import cn.supspider.Utils.UtilMethods;
import cn.supspider.bean.ad_allWebinfo;
import cn.supspider.bean.advs;
import cn.supspider.bean.userbean;
import cn.supspider.bean.userinfo;
import net.sf.json.JSONArray;

@Transactional	
public class ad extends ActionSupport implements ModelDriven<userbean>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 该action用于管理员登录:
	 * 
	 * 
	 * */
	//注入javabean
	private userbean bean;
	public void setBean(userbean bean) {
		this.bean = bean;
	}
	//注入hibernate模板
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	ActionContext context=ActionContext.getContext();
	
	//注入Json工具类
	private ToJsonType ToJson;
	public void setToJson(ToJsonType toJson) {
		ToJson = toJson;
	}
	//save网站信息
	private ad_allWebinfo ad_allWebinfo;
	public void setAd_allWebinfo(ad_allWebinfo ad_allWebinfo) {
		this.ad_allWebinfo = ad_allWebinfo;
	}
	//获取response对象
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request=ServletActionContext.getRequest();
	
	//注入广告bean
	private advs advs;
	public void setAdvs(advs advs) {
		this.advs = advs;
	}
	//注入获取当前系统时间的方法
	private UtilMethods utilMethods;
	public void setUtilMethods(UtilMethods utilMethods) {
		this.utilMethods = utilMethods;
	}
	//注入userinfo做用户操作
	private userinfo userinfo;
	public void setUserinfo(userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String execute() throws Exception {
		//管理员登录验证
		@SuppressWarnings("unchecked")
		List<userbean> list=(List<userbean>) hibernateTemplate.find("FROM userbean WHERE name=? AND password=?", bean.getName(),bean.getPassword());
		if(list.isEmpty()) {
			return "failed";
		}else {
			//将用户名存入session,用于做判断是否登录.
			context.getSession().put("username", bean.getName());
			return SUCCESS;
		}
	}
	
	public userbean getModel() {
		return bean;
	}
	
	//注销登录操作
	public String exit() {
		return "exit";
	}
	
	//接收管理页面的网站信息管理的请求和数据返回
	public String QueryWebInfo() throws IOException {
		@SuppressWarnings({ "unchecked", "unused" })
		List<ad_allWebinfo> list_webinfo=(List<ad_allWebinfo>) hibernateTemplate.find("FROM ad_allWebinfo WHERE number=?", 1);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		if(!list_webinfo.isEmpty()) {
			JSONArray json=ToJson.List2Json(list_webinfo);
			String Sjson=json.toString();
			out.print(Sjson);//返回数据
			System.out.println("管理页面动静"+Sjson);
		}
		return NONE;
	}
	
	//修改存储网站信息
	private String web_Name;
	private String web_Keyword;
	private String web_Introduce;
	private int userid;
	public String getWeb_Name() {
		return web_Name;
	}
	public void setWeb_Name(String web_Name) {
		this.web_Name = web_Name;
	}
	public String getWeb_Keyword() {
		return web_Keyword;
	}
	public void setWeb_Keyword(String web_Keyword) {
		this.web_Keyword = web_Keyword;
	}
	public String getWeb_Introduce() {
		return web_Introduce;
	}
	public void setWeb_Introduce(String web_Introduce) {
		this.web_Introduce = web_Introduce;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	//请求响应
	public String SaveWebInfo() throws IOException {
		
		if(getWeb_Name().equals("")&&getWeb_Keyword().equals("")&&getWeb_Introduce().equals("")) {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			out.print("send_null");//返回数据
		}else {
			ad_allWebinfo.setNumber(1);
			ad_allWebinfo.setWeb_Name(getWeb_Name());
			ad_allWebinfo.setWeb_Keyword(getWeb_Keyword());
			ad_allWebinfo.setWeb_Introduce(getWeb_Introduce());
			ad_allWebinfo.setWeb_Open(0);
			hibernateTemplate.update(ad_allWebinfo);//存入数据库
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			out.print(1);//返回数据
		}
		return NONE;
	}
	
	//查询用户
	private String search_input;
	public String getSearch_input() {
		return search_input;
	}
	public void setSearch_input(String search_input) {
		this.search_input = search_input;
	}
	public String QueryUserinfo() throws IOException {
		@SuppressWarnings({ "unchecked", "unused" })
		List<userinfo> listName=(List<userinfo>) hibernateTemplate.find("FROM userinfo WHERE UserName=?", getSearch_input());
		@SuppressWarnings({ "unchecked", "unused" })
		List<userinfo> listEmail=(List<userinfo>) hibernateTemplate.find("FROM userinfo WHERE Email=?", getSearch_input());
		if(!listName.isEmpty()) {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			JSONArray json=ToJson.List2Json(listName);
			System.out.println(json);
			out.println(json);
		}else if(!listEmail.isEmpty()) {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			JSONArray json=ToJson.List2Json(listName);
			System.out.println(json);
			out.println(json);
		}else {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			System.out.println(0);
			out.println(0);
		}
		return NONE;
	}
	//查询所有用户(用原jsp方法代替)
	
	//查询广告代码
	private String adv;
	public String getAdv() {
		return adv;
	}
	public void setAdv(String adv) {
		this.adv = adv;
	}
	public String QueryAdvsInfo() throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		@SuppressWarnings("unchecked")
		List<advs> adv_code=(List<cn.supspider.bean.advs>) hibernateTemplate.find("FROM advs WHERE advs_name=?", getAdv());
		if(!adv_code.isEmpty()) {
			out.println(ToJson.List2Json(adv_code));//返回查询值
			System.out.println(ToJson.List2Json(adv_code));
		}else {
			out.println(0);//查询未果
		}
		return NONE;
	}
	
	
	//修改广告代码
	private String Advs_code;
	private String Advs_name;
	private int Advs_id;
	public String getAdvs_code() {
		return Advs_code;
	}
	public void setAdvs_code(String advs_code) {
		Advs_code = advs_code;
	}
	public String getAdvs_name() {
		return Advs_name;
	}
	public void setAdvs_name(String advs_name) {
		Advs_name = advs_name;
	}
	public int getAdvs_id() {
		return Advs_id;
	}
	public void setAdvs_id(int advs_id) {
		Advs_id = advs_id;
	}

	public String UpdateAdvsCode() throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		advs.setId(getAdvs_id());
		advs.setAdvs_name(getAdvs_name());
		advs.setAdvs_context(getAdvs_code());
		advs.setAdvs_altertime(utilMethods.getNowSystemTime());
		hibernateTemplate.saveOrUpdate(advs);
		out.println(1);
		return NONE;
	}
	//删除指定的广告
	public String DeleteAdvsCode() throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		advs.setId(getAdvs_id());
		advs.setAdvs_name(getAdvs_name());
		advs.setAdvs_context(null);
		advs.setAdvs_altertime(utilMethods.getNowSystemTime());
		hibernateTemplate.update(advs);
		out.println(1);
		return NONE;
	}
	//用户管理系统删除用户
	public String DeleteUserInfo() throws IOException {
		userinfo.setId(getUserid());
		hibernateTemplate.delete(userinfo);
		return "deletesu";
	}
	
}
