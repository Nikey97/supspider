package cn.kuqi.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.kuqi.JsonUtil.JsonAllUtil;
import cn.kuqi.Pojo.Article;
import cn.kuqi.Pojo.ArticleClassfiy;
import cn.kuqi.Pojo.ArticleClassfiyExt;
import cn.kuqi.Pojo.ArticleExt;
import cn.kuqi.Pojo.Bloginfo;
import cn.kuqi.Pojo.Link;
import cn.kuqi.Pojo.LinkExt;
import cn.kuqi.Pojo.MessageInfo;
import cn.kuqi.Pojo.Users;
import cn.kuqi.Pojo.UsersExt;
import cn.kuqi.ServiceImpi.AdminBackstageServiceImpi;


@Controller
@RequestMapping("/admin")
public class AdminBackStageController {
	
	@Autowired 
	AdminBackstageServiceImpi adminBackstageServiceImpi;
	
	
	@SuppressWarnings("unused")
	@RequestMapping("/index")//管理系统首页
	public String index(HttpServletRequest request,Model model,HttpSession session) {
		System.out.println("/index：    执行");
		session = request.getSession();
		String username = (String) session.getAttribute("account");
		System.out.println(username);
		if (!username.equals("") || username !=null) {
			//存在管理员登录,返回查询数据。
			
			return "admin/index";
		}else {
			//未登录情况，重定向至login。
			return "redirect:admin/login";
		}
	}
	
	@RequestMapping("/login")//管理系统登录
	public String login(HttpServletRequest request, Model model, HttpSession session, String account, String psw) {
		
		
		int code = adminBackstageServiceImpi.QueryUserLoginInfo(account, psw);
		
		//登录成功
		if (code == 0) {
			session.setAttribute("account", account);//在session中存入用户
			return "redirect:admin/index";
		}
		//密码错误
		if (code == 1) {
			model.addAttribute("status", "输入的密码错误，请再次输入");
		}
		//账号不存在
		if (code == 2) {
			model.addAttribute("status", "输入的账号不存在，请查证后输入");
		}
		
		return null;
	}
	
	@RequestMapping(value= ("/query_classfiy.do"),method= {RequestMethod.GET})//获取全部分类
	public@ResponseBody ArticleClassfiyExt QueryClassfiy() {
		ArticleClassfiyExt articleClassfiyExt = adminBackstageServiceImpi.QueryAllArticleClassfiyService();
		return articleClassfiyExt;
	}
	
	@RequestMapping(value= ("/add_classfiy.do"),method= {RequestMethod.POST})//添加一个分类
	public @ResponseBody MessageInfo AddClassfiy(@RequestBody ArticleClassfiy articleClassfiy) {
		
		MessageInfo msg = adminBackstageServiceImpi.AddClassfiyService(articleClassfiy.getAcClassfiyname(), articleClassfiy.getAcRemark());
		
		return msg;
	}
	
	@RequestMapping(value= ("/alter_query_classfiy.do"),method= {RequestMethod.POST})//修改查询分类
	public@ResponseBody ArticleClassfiy AlterQueryClassfiy(@RequestBody ArticleClassfiy articleClassfiy,HttpServletResponse response) throws IOException {
		
		ArticleClassfiy Classfiy = adminBackstageServiceImpi.SelectArticleClassfiyService(articleClassfiy.getAcNumber());
		//容错判断
		if (Classfiy != null) {
			return Classfiy;
		}else {
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("{\"code\":1,\"msg\":\"分类不存在\"}");
			out.close();//返回错误信息
			return null;
		}
	}
	
	@RequestMapping(value= ("/alter_classfiy.do"),method= {RequestMethod.POST})//修改分类
	public@ResponseBody MessageInfo AlterClassfiy(@RequestBody ArticleClassfiy articleClassfiy) {
		MessageInfo msg = adminBackstageServiceImpi.UpdataArticleClassfiyService(articleClassfiy.getAcNumber(), articleClassfiy.getAcClassfiyname(), articleClassfiy.getAcRemark());
		return msg;
	}
	
	@RequestMapping(value= ("/delete_classfiy.do "),method= {RequestMethod.POST})//删除文章分类
	public @ResponseBody MessageInfo DeleteAlterClassfiy(@RequestBody ArticleClassfiy articleClassfiy) {
		MessageInfo messageInfo = adminBackstageServiceImpi.DeleteArticleClassfiyService(articleClassfiy.getAcNumber());
		return messageInfo;
	}
	
	@RequestMapping(value= ("/query_article.do"),method= {RequestMethod.GET})//文章操作  
	public @ResponseBody ArticleExt QueryAllArticle() {
		ArticleExt articleExt = adminBackstageServiceImpi.QueryAllArticleService();
		return articleExt;
	} 
	
	@RequestMapping(value= ("/delete_article.do"),method= {RequestMethod.POST})//删除文章
	public@ResponseBody MessageInfo DeleteArticleByNumber(@RequestBody Article article) {
		MessageInfo msg = adminBackstageServiceImpi.DeleteArticleByNumberService(article.getaNumber());
		return msg;
	}
	/*
	 *   修改文章
	 * 		需求分析：
	 *			controller接收前台的文章编号，Dao查询返回数据。 
	 * 			并转发到编辑页面
	 * */
	@RequestMapping(value= ("/alter_article"),method= {RequestMethod.POST})
	public String AlterArticleByNumber(Integer ArticleNumber,String ArticleContent,Model model) {
		
		//查询回显执行的
		if (ArticleNumber != null && ArticleContent == null) {
			Article article = adminBackstageServiceImpi.QueryArticleByNumberService(ArticleNumber);
			model.addAttribute("article", article);//向页面回显数据
			return null;//转向发博客页面
		}
		
		//修改执行的
		if (ArticleNumber != null && ArticleContent != null) {
			String json = adminBackstageServiceImpi.UpdataArticleByNumberService(ArticleNumber, ArticleContent);//拿到执行结果
			model.addAttribute("msg", json);//向页面回显数据
			return null;//转向发博客页面
		}
		
		model.addAttribute("msg", "请求异常，请联系管理员");
		return null;//转向发博客页面
	}
	
	@RequestMapping(value= ("/queryClassfiy_article.do"),method= {RequestMethod.POST})//使用分类来查询文章
	public @ResponseBody ArticleExt QueryArticleByClassfiy(@RequestBody ArticleClassfiy articleClassfiy) {
		ArticleExt articleExt = adminBackstageServiceImpi.QueryArticleByClassfiyService(articleClassfiy.getAcNumber());
		return articleExt;
	}
	
	@RequestMapping(value= ("/add_article.do"),method= {RequestMethod.POST})//使用分类来查询文章
	public String AddArticle(Article article,Model model) {
		String msg = adminBackstageServiceImpi.AddArticleService(article);
		model.addAttribute("msg", msg);
		return null;//转发到发博客页
	}
	
	@RequestMapping(value= ("/add_link.do"),method= {RequestMethod.POST})//添加链接
	public @ResponseBody MessageInfo AddLink(@RequestBody Link link) {
		MessageInfo messageInfo = adminBackstageServiceImpi.AddLinkService(link);
		return messageInfo;
	}
	
	@RequestMapping(value= ("/query_link.do"),method= {RequestMethod.POST})//查询所有链接或者单条  
	public@ResponseBody LinkExt QueryLink(@RequestBody Link link) {
		LinkExt linkExt = adminBackstageServiceImpi.QueryLinkService(link);
		return linkExt;
	}
	
	@RequestMapping(value= ("/delete_link.do"),method= {RequestMethod.POST})//删除友链
	public@ResponseBody MessageInfo DeleteLink(@RequestBody Link link) {
		MessageInfo messageInfo = adminBackstageServiceImpi.DeleteLinkService(link);
		return messageInfo;
	}
	
	@RequestMapping(value= ("/alter_link.do"),method= {RequestMethod.POST})//修改友链
	public@ResponseBody LinkExt AlterLink(@RequestBody Link link, HttpServletRequest request, HttpServletResponse response) throws IOException {
		JsonAllUtil jsonutil = new JsonAllUtil();//获取转化工具
		
		if (link.getlNumber() != null && link.getlName() == null && link.getlLink() == null) {
			//返回link数据
			LinkExt linkExt = adminBackstageServiceImpi.QueryLinkService(link);
			return linkExt;
		}  
		if (link.getlNumber() != null && link.getlName() != null && link.getlLink() != null) {
			//修改数据
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();//获取回显对象
			MessageInfo messageInfo = adminBackstageServiceImpi.AlterLinkService(link);
			String msg = jsonutil.PojoToJson(messageInfo);
			out.println(msg);
			out.close();
		}
		return null;
	}
	
	
	
	/*
	 *	管理系统 --> 用户管理 
	 * 	需求分析：
	 * 			对用户进行增删改查
	 * */
	@RequestMapping(value= ("/query_user.do"),method= {RequestMethod.POST})//多条件查询用户
	public @ResponseBody UsersExt QueryUser (@RequestBody Users users) {
		UsersExt usersExt = adminBackstageServiceImpi.QueryUsersInfoByAllDataService(users);
		return usersExt;
	}
	
	@RequestMapping(value= ("/delete_user.do"),method= {RequestMethod.POST})//删除用户
	public@ResponseBody MessageInfo DeleteUserByID(@RequestBody Users users) {
		MessageInfo messageInfo = adminBackstageServiceImpi.DeleteUserByIDService(users);
		return messageInfo;
	}
	
	@RequestMapping(value= ("/alter_user.do"),method= {RequestMethod.POST})//修改用户信息
	public @ResponseBody MessageInfo AlterUsersByID(@RequestBody Users users, HttpServletResponse response) throws IOException {
		MessageInfo messageInfo = adminBackstageServiceImpi.AlterUserInfoByIdService(users);
		return messageInfo;
	}
	
	
	/*
	 * 博客管理-->信息操作 
	 * 	需求分析：
	 * 			1.进入页面请求响应博客信息，设置到表单显示。   信息查询接口
	 * 			2.修改信息		信息修改接口
	 * */
	@RequestMapping(value= ("/query_bloginfo.do"),method= {RequestMethod.GET})//查询博客信息
	public @ResponseBody Bloginfo QueryBlogInfo() {
		Bloginfo bloginfo = adminBackstageServiceImpi.QueryBlogInfoService();
		return bloginfo;
	}
	
	@RequestMapping(value= ("/alter_bloginfo.do"),method= {RequestMethod.POST})//修改博客信息
	public @ResponseBody MessageInfo AlterBlogInfo(@RequestBody Bloginfo bloginfo) {
		MessageInfo messageInfo = adminBackstageServiceImpi.AlterBlogInfoService(bloginfo);
		return messageInfo;
	}
	
	
	/*
	 *  博客管理--> 主题操作    
	 * 				需求分析:
	 * 					1.上传主题
	 * 					2.修改主题信息
	 * 					3.删除主题
	 * */
	@RequestMapping(value= ("/upload_theme.do"),method= {RequestMethod.POST})//上传主题
	public String UploadTheme(@RequestParam("file") MultipartFile meMultipartFile) {
		
		return null;
	}
	
}
