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
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kuqi.Pojo.ArticleClassfiy;
import cn.kuqi.Pojo.ArticleClassfiyExt;
import cn.kuqi.Pojo.MessageInfo;
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
	
	@RequestMapping(value= ("/query_classfiy.do"),method= {RequestMethod.GET})//获取全部分类接口
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
	
	@RequestMapping(value= ("/alter_classfiy.do "),method= {RequestMethod.POST})//修改分类
	public@ResponseBody MessageInfo AlterClassfiy(@RequestBody ArticleClassfiy articleClassfiy) {
		MessageInfo msg = adminBackstageServiceImpi.UpdataArticleClassfiyService(articleClassfiy.getAcNumber(), articleClassfiy.getAcClassfiyname(), articleClassfiy.getAcRemark());
		return msg;
	}
	
	@RequestMapping(value= ("/delete_classfiy.do "),method= {RequestMethod.POST})//删除文章分类
	public @ResponseBody MessageInfo DeleteAlterClassfiy(@RequestBody ArticleClassfiy articleClassfiy) {
		MessageInfo messageInfo = adminBackstageServiceImpi.DeleteArticleClassfiyService(articleClassfiy.getAcNumber());
		return messageInfo;
	}
	
}
