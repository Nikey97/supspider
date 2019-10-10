package cn.kuqi.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import cn.kuqi.Annotation.CheckUserIdentity;
import cn.kuqi.DateUtil.ZipUtils;
import cn.kuqi.Pojo.Article;
import cn.kuqi.Pojo.ArticleClassfiy;
import cn.kuqi.Pojo.ArticleExt;
import cn.kuqi.Pojo.BlogInfoJoinTheme;
import cn.kuqi.Pojo.Bloginfo;
import cn.kuqi.Pojo.Link;
import cn.kuqi.Pojo.MessageInfo;
import cn.kuqi.Pojo.Users;
import cn.kuqi.Poptis.PropertiesUtils;
import cn.kuqi.ServiceImpi.AdminBackstageServiceImpi;

@Controller
@RequestMapping("/admin")
public class AdminBackStageController {
	
	@Autowired 
	AdminBackstageServiceImpi adminBackstageServiceImpi;
	
	/**
	 * 创建人：Nikey
	 * 创建时间：2018年11月4日下午11:40:45
	 * 创建功能：管理页面首页的功能
	 * 创建备注：请求先验证用户，通过后从session中获取用户账号返回
	 * @version
	 */
	@CheckUserIdentity
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String acc = (String) session.getAttribute("account");
		model.addAttribute("account", acc);
		return "admin/index.html";
	}
	
	/**
	 * 创建人：Nikey
	 * 创建时间：2018年11月4日下午8:59:34
	 * 创建功能：用户登录接口（接收：账号、密码）
	 * 创建备注：账户密码为空表示请求加载页面，有账号密码说明登录请求
	 * @version
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model, 
			HttpSession session, String account, String psw) {
		if (account != null && psw != null) {
			int code = adminBackstageServiceImpi.QueryUserLoginInfo(account, psw);
			if (code == 0) {
				session.setAttribute("account", account);//在session中存入用户
				return "redirect:index";//登录成功
			}
			if (code == 1) {
				model.addAttribute("status", "输入的密码错误，请再次输入");//密码错误
			}
			if (code == 2) {
				model.addAttribute("status", "输入的账号不存在，请查证后输入");//账号不存在
			}
		}else {
			String acc = (String) session.getAttribute("account");
			model.addAttribute("account", acc);//在显示用户的时候查询是否有用户登录
		}
		return "admin/login.html";
	}
	
	/**
	 * 创建人：Nikey
	 * 创建时间：2018年11月4日下午11:42:26
	 * 创建功能：管理页面用户注销接口
	 * 创建备注：判断是否存在用户，存在就注销，不存在就返回信息
	 * @version
	 */
	@CheckUserIdentity
	@RequestMapping("/logout")
	public String UserLogout(HttpSession session, Model model) {
		String msg = null;
		String acc = (String) session.getAttribute("account");
		if (acc != null) {
			session.removeAttribute("account");//删除用户信息
			model.addAttribute("status", "注销成功！");
			msg = "admin/login.html";
		}
		return msg;
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: QueryClassfiy
	  * @Description: 获取全部的分类（支持分页）   
	  * @return ArticleClassfiyExt     
	  * @date: 2018年11月23日 下午11:03:14  
	  * @todo: TODO
	  */
	@Transactional(readOnly = true)
	@RequestMapping("/classfiy")
	public String queryClassfiy(Model model, Integer pager) {
		int pagers = 0;
		if (pager == null || pager <= 0) {
			pager = 0;
		}else {
			pagers = pager-1;
		}
		int PagerAll = adminBackstageServiceImpi.QueryCountArticleClassfiyService();
		List<ArticleClassfiy> list = adminBackstageServiceImpi.QueryAllArticleClassfiyService(pagers*5,5);
		model.addAttribute("dataList", list);
		model.addAttribute("pagerAll", PagerAll);
		model.addAttribute("pagerNow", pager);
		return "admin/classify.html";
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName:QueryClassfiyUpdata
	  * @Description: 通过分类编号查文章分类信息   
	  * @return      
	  * @date: 2018年11月29日 下午4:07:35  
	  * @todo: TODO
	  */
	@RequestMapping("/query_classfiy.do")
	public @ResponseBody ArticleClassfiy queryClassfiyUpdata(int number) {
		return adminBackstageServiceImpi.QueryOneArticleClassfiyService(number);
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: AddClassfiy
	  * @Description: 用于添加文章的分类操作  （检查是否登录）
	  * @return MessageInfo     
	  * @date: 2018年11月23日 下午10:59:43  
	  * @todo: TODO
	  */
	@CheckUserIdentity
	@RequestMapping(value= ("/add_classfiy.do"),method= {RequestMethod.POST})//添加一个分类
	public String AddClassfiy(String classfiyName, String classfiyDescription, Model model) {
		int i = adminBackstageServiceImpi.AddClassfiyService(classfiyName, classfiyDescription);
		if (i == 1) {
			model.addAttribute("msgs", "添加成功！");
		}else {
			model.addAttribute("msgs", "添加失败！");
		}
		return "admin/classify.html";
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName:AlterClassfiy
	  * @Description:修改查询分类  
	  * @return return_type     
	  * @date: 2018年11月29日 下午5:11:29  
	  * @todo: TODO
	  */
	@CheckUserIdentity
	@RequestMapping(value= ("/alter_classfiy.do"),method= {RequestMethod.POST})//修改分类
	public String AlterClassfiy(Integer classfiyNumberUpdata, String classfiyNameUpdata, String classfiyDescriptionUpdata, Model model) {
		int i = adminBackstageServiceImpi.UpdataArticleClassfiyService(classfiyNumberUpdata,classfiyNameUpdata,classfiyDescriptionUpdata);
		switch (i) {
		case 0:
			model.addAttribute("msgs", "修改失败！");
			break;
		case 1:
			model.addAttribute("msgs", "修改成功！");
			break;
		case 2:
			model.addAttribute("msgs", "系统检测：没有修改内容，不执行更新。");
			break;
		default:
			break;
		}
		return "admin/classify.html";
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: DeleteAlterClassfiy
	  * @Description:删除文章分类 
	  * @return return_type    
	  * @date: 2018年11月29日 下午5:42:22  
	  * @todo: TODO
	  */
	@CheckUserIdentity
	@RequestMapping(value= ("/delete_classfiy.do"),method= {RequestMethod.POST})
	public @ResponseBody MessageInfo DeleteAlterClassfiy(@RequestParam("classfiyList[]") ArrayList<Integer> classfiyList, 
			Model model) {
		return adminBackstageServiceImpi.DeleteArticleClassfiyService(classfiyList);
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: QueryAllArticle
	  * @Description: 查询文章（支持分页）  
	  * @return ArticleExt     
	  * @date: 2018年12月3日 下午9:32:54  
	  * @todo: TODO
	  */
	@CheckUserIdentity
	@RequestMapping(value= ("/article"),method= {RequestMethod.GET})
	public String QueryAllArticle(Model model, Integer pager) {
		int pagers = 0;
		if (pager == null || pager <= 0) {
			pager = 0;
		}else {
			pagers = pager-1;
		}
		int all = adminBackstageServiceImpi.QueryAllCountArticleService();
		List<Article> articles = adminBackstageServiceImpi.QueryAllArticleService(pagers*5, 5);
		model.addAttribute("dataList", articles);
		model.addAttribute("pagerAll", all);
		model.addAttribute("pagerNow", pager);
		return "admin/operation.html";
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: DeleteArticleByNumber
	  * @Description: 删除文章  
	  * @return return_type     
	  * @date: 2018年12月4日 上午11:38:27  
	  * @todo: TODO
	  */
	@CheckUserIdentity
	@RequestMapping(value= ("/delete_article.do"),method= {RequestMethod.POST})//删除文章
	public @ResponseBody MessageInfo DeleteArticleByNumber(Integer number, Model model) {
		return null;
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: draft
	  * @Description: 查询未发布的文章   （支持分页）
	  * @return String     
	  * @date: 2018年12月6日 上午9:58:55  
	  * @todo: TODO
	  */
	@CheckUserIdentity
	@RequestMapping("/draft")
	public String draft(Model model, Integer pager) {
		int pagers = 0;
		if (pager == null || pager <= 0) {
			pager = 0;
		}else {
			pagers = pager-1;
		}
		int all = adminBackstageServiceImpi.QueryNotPublisArticleCountServices();
		List<Article> articles= adminBackstageServiceImpi.QueryNotPublisArticleServices(pagers*5, 5);
		model.addAttribute("dataList", articles);
		model.addAttribute("pagerAll", all);
		model.addAttribute("pagerNow", pager);
		return "admin/draft.html";
	}
	
	/*
	 *   修改文章
	 * 		需求分析：
	 *			controller接收前台的文章编号，Dao查询返回数据。 
	 * 			并转发到编辑页面
	 * */
	@RequestMapping(value= ("/alter_article"),method= {RequestMethod.POST})
	public String alterArticleByNumber(Integer ArticleNumber,String ArticleContent,Model model) {
		
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
	public @ResponseBody ArticleExt queryArticleByClassfiy(@RequestBody ArticleClassfiy articleClassfiy) {
		ArticleExt articleExt = adminBackstageServiceImpi.QueryArticleByClassfiyService(articleClassfiy.getAcNumber());
		return articleExt;
	}
	
	@RequestMapping(value= ("/add_article.do"),method= {RequestMethod.POST})//使用分类来查询文章
	public String addArticle(Article article,Model model) {
		String msg = adminBackstageServiceImpi.AddArticleService(article);
		model.addAttribute("msg", msg);
		return null;//转发到发博客页
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: 
	  * @Description: 友情链接: 添加友链
	  * @return String     
	  * @date: 2019年1月16日 下午4:36:30  
	  * @todo: TODO
	  */
	@RequestMapping(value= ("/add_link.do"),method= {RequestMethod.POST})
	public @ResponseBody MessageInfo addLink(@RequestBody Link link) {
		MessageInfo messageInfo = getMessageInfoInstance();
		Integer i = adminBackstageServiceImpi.addLinkService(link);
		if (i == 0) {
			messageInfo.setCode(1);
			messageInfo.setMsg("Fail! 添加名称有重复");
		}else if (i == 1){
			messageInfo.setCode(0);
			messageInfo.setMsg("Ok! 添加成功");
		}
		return messageInfo;
	}
	
	/**
	 * @author Nikey
	 * @Description: 友情链接：分页查询
	 * @MethodName: queryLink
	 * @param String 页面转跳
	 */
	@RequestMapping(value="/link")  
	public String queryLink(Model model, Integer pager) {
		int pagers = 0;
		if (pager == null || pager <= 0) {
			pager = 0;
		}else {
			pagers = pager-1;
		}
		List<Link> link = adminBackstageServiceImpi.queryLinkService(pagers,5);
		int all = adminBackstageServiceImpi.queryAllLinkService();
		model.addAttribute("dataList", link);
		model.addAttribute("pagerAll", all);
		model.addAttribute("pagerNow", pager);
		return "admin/friendLink.html";
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: deleteLink
	  * @Description: 友情链接： 删除链接  
	  * @return MessageInfo json响应信息提供     
	  * @date: 2019年1月21日 下午5:54:06  
	  * @todo: TODO
	  */
	@RequestMapping(value= ("/delete_link.do"),method= {RequestMethod.POST})//删除友链
	public @ResponseBody MessageInfo deleteLink(@RequestBody Link link) {
		MessageInfo messageInfo = getMessageInfoInstance();
		int i = adminBackstageServiceImpi.deleteLinkService(link);
		if (i == 1) {
			messageInfo = returnJsonMsgs(messageInfo, 0, "Ok!, 删除成功", "100", true);
		}else {
			messageInfo = returnJsonMsgs(messageInfo, 1, "Fail!, 不存在该友链", "404", false);
		}
		return messageInfo;
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: alterLink
	  * @Description: 友情链接: 修改友链
	  * @return return_type     
	  * @date: 2019年1月21日 下午6:41:11  
	  * @todo: TODO
	  */
	@RequestMapping(value= ("/alter_link.do"),method= {RequestMethod.POST})
	public@ResponseBody MessageInfo alterLink(@RequestBody Link link) throws IOException {
		MessageInfo messageInfo = getMessageInfoInstance();
		int i = adminBackstageServiceImpi.alterLinkService(link);
		if (i == 1) {
			messageInfo = returnJsonMsgs(messageInfo, 0, "Ok!,修改成功", "100", true);
		}else {
			messageInfo = returnJsonMsgs(messageInfo, 1, "Fail!,不存在该友链", "404", false);
		}
		return messageInfo;
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: queryAlterLink
	  * @Description: 查询修改友链信息  
	  * @return List     
	  * @date: 2019年1月21日 下午7:19:31  
	  * @todo: TODO
	  */
	@RequestMapping(value= ("/query_AlterLink.do"),method= {RequestMethod.POST})
	public @ResponseBody List<Link> queryAlterLink(Integer number) throws IOException {
		return adminBackstageServiceImpi.queryOneLinkService(number);
	}
	
	
	
	/**  
	  * @user: Nikey 
	  * @MethodName: queryUser 
	  * @Description: 管理系统 --> 用户管理    多条件查询用户 
	  * @return String     
	  * @date: 2018年12月8日 下午5:42:34  
	  * @todo: TODO
	  */  
	@RequestMapping(value= ("/users"))
	public String queryUser (Integer pager, Model model) {
		int pagers = 0;
		if (pager == null || pager <= 0) {
			pager = 0;
		}else {
			pagers = pager-1;
		}
		List<Users> list = adminBackstageServiceImpi.queryUsersInfoByAllService(pagers, 5);
		int usersAll = adminBackstageServiceImpi.queryCountUserInfo();
		model.addAttribute("pagerAll", usersAll);
		model.addAttribute("pagerNow", pager);
		model.addAttribute("dataList", list);
		return "admin/users.html";
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: queryUsers
	  * @Description: 用户搜索查询   
	  * @return String     
	  * @date: 2019年1月27日 下午3:03:43  
	  * @todo: TODO
	  */
	@RequestMapping(value="/user")
	public String queryUsers(String user, Integer pager, Model model) {
		int pagers = 0;
		int listSize;
		if (pager == null || pager <= 0) {
			pager = 0;
		}else {
			pagers = pager-1;
		}
		List<Users> list = adminBackstageServiceImpi.queryUsersService(pagers, 5, user);
		if (list == null) {
			listSize = 0; 
		}else {
			listSize = list.size();
		}
		model.addAttribute("pagerAll", listSize);
		model.addAttribute("pagerNow", pager);
		model.addAttribute("dataList", list);
		return "admin/users.html";
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName:deleteUserByID
	  * @Description: 用户管理 -- 删除用户(支持单个和批量)   
	  * @return MessageInfo     
	  * @date: 2019年1月27日 下午3:52:21  
	  * @todo: TODO
	  */
	@RequestMapping(value= ("/delete_user.do"),method= {RequestMethod.POST})
	public@ResponseBody MessageInfo deleteUserByID(@RequestParam("usersList[]") ArrayList<Integer> users) {
		return adminBackstageServiceImpi.deleteUserByIDService(users);
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: queryAlterUsersByID
	  * @Description: 用户管理--查询修改用户   
	  * @return List<Users>     
	  * @date: 2019年1月27日 下午4:59:59  
	  * @todo: TODO
	  */
	@RequestMapping(value= ("/query_AlterUser.do"),method= {RequestMethod.POST})
	public @ResponseBody List<Users> queryAlterUsersByID(@RequestParam("usersList[]") ArrayList<Integer> id) {
		return adminBackstageServiceImpi.queryUsersService(0, 5, id.get(0).toString());
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName:alterUsersByID
	  * @Description: 用户管理--修改用户   
	  * @return MessageInfo     
	  * @date: 2019年1月27日 下午4:59:59  
	  * @todo: TODO
	  */
	@RequestMapping(value= ("/alter_user.do"),method= {RequestMethod.POST})
	public @ResponseBody MessageInfo alterUsersByID(@RequestBody Users users) throws IOException {
		return adminBackstageServiceImpi.alterUserInfoByIdService(users);
	}
	
	
	
	/**
	 * 博客管理-->信息操作 
	 * 	需求分析：
	 * 			1.进入页面请求响应博客信息，设置到表单显示。   信息查询接口
	 * 			2.修改信息		信息修改接口
	 * @author Nikey
	 * @param
	 * */
	
	@RequestMapping(value= ("/alter_bloginfo.do"),method= {RequestMethod.POST})//修改博客信息
	public String alterBlogInfo(Bloginfo bloginfo) {
		adminBackstageServiceImpi.alterBlogInfoService(bloginfo);
		return "redirect:updataBlog";
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: updataBlogInfo
	  * @Description: 查询显示博客信息页  
	  * @return String     
	  * @date: 2019年1月7日 下午9:39:02  
	  * @todo: TODO
	  */
	@RequestMapping(value= ("/updataBlog"))
	public String updataBlogInfo(Model model) {
		BlogInfoJoinTheme bTheme = adminBackstageServiceImpi.queryBlogInfoService();
		model.addAttribute("data", bTheme);
		return "admin/webinfo.html";
	}
	
	/**
	 * 博客设置 -- 头像上传
	 * @author Nikey
	 * @param HttpServletRequest 接受前端的文件
	 * @return String 响应参数
	 * */
	@RequestMapping(value= ("/upload_imgHead.do"),method= {RequestMethod.POST})
	public String uploadHeadImg(MultipartFile meFile) {
		if (meFile != null) {
			try {
				String newFileName = (UUID.randomUUID()+meFile.getOriginalFilename()).replaceAll("-", "");
				String rootUrl = "G:";
				String url = "/temp/";
				meFile.transferTo(new File(rootUrl+url+newFileName));
				Bloginfo bloginfo = getBloginfoInstance();
				bloginfo.setBiHeadportrait(url+newFileName);
				adminBackstageServiceImpi.alterBlogInfoService(bloginfo);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:updataBlog";
	}
	
	
	/*
	 *  博客管理--> 主题操作    
	 * 				需求分析:
	 * 					1.上传主题：上传文件夹（css样式文件、图片资源）
	 * 					2.修改主题信息
	 * 					3.删除主题
	 * */
	
	@SuppressWarnings("static-access")
	@RequestMapping("/upload_theme.do")//上传主题
	public String UploadTheme(HttpServletRequest request,Model model){
		MultipartResolver cResolver = new CommonsMultipartResolver();
		if (cResolver.isMultipart(request)) {//判断是不是Multipart格式的数据
			MultipartHttpServletRequest httpservletrequest = (MultipartHttpServletRequest) request;//将文件格式的请求装入MultipartHttpServletRequest对象中。
			List<MultipartFile> list = httpservletrequest.getFiles("meFile");//通过调用该方法取出文件到list
			for (int i = 0; i < list.size(); i++) {
				try {
					list.get(i).transferTo(new File("G:/temp/"+list.get(i).getOriginalFilename()));
					ZipUtils.resolveZip("G:/temp/"+list.get(i).getOriginalFilename());
				} catch (IllegalStateException e) {
					e.printStackTrace();
					model.addAttribute("msg", "上传失败");
					return "error";
				} catch (IOException e) {
					e.printStackTrace();
					model.addAttribute("msg", "上传失败");
					return "error";
				}
			}
		}
		model.addAttribute("msg", "上传成功");
		return "index";
	}
	
	@RequestMapping("/textUpload.do")
	public String TextUpload(String text,String title,Model model) {
		System.out.println("title: "+title+" "+"text: "+text);
		model.addAttribute("title", title);
		model.addAttribute("text", text);
		return "admin/showText.html";
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: install
	  * @Description: 博客安装路径  
	  * @return {@link String}      
	  * @throws IOException 
	  * @throws FileNotFoundException 
	  * @date: 2019年3月26日 下午4:01:51  
	  * @todo: TODO
	  */
	@RequestMapping("/install")
	public String install() throws FileNotFoundException, IOException {
		PropertiesUtils propertiesUtils = new PropertiesUtils();
		propertiesUtils.isFile();
		return null;
	}
	
	/**
	 * 单例对象
	 * */
	static Bloginfo bloginfo;
	static MessageInfo messageInfo;
	
	/**
	 * @author Nikey
	 * @Description: 单例Bloginfo
	 * */
	private synchronized static Bloginfo getBloginfoInstance() {
		if (bloginfo == null) {
			bloginfo = new Bloginfo();
		}
		return bloginfo;
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName:getMessageInfoInstance
	  * @Description: 单例MessageInfo  
	  * @return MessageInfo     
	  * @date: 2019年1月16日 下午4:41:03  
	  * @todo: TODO
	  */
	private synchronized static MessageInfo getMessageInfoInstance() {
		if (messageInfo == null) {
			messageInfo = new MessageInfo();
		}
		return messageInfo;
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: returnOk
	  * @Description: 返回json响应的信息  
	  * @return MessageInfo     
	  * @date: 2019年1月21日 下午7:01:57  
	  * @todo: TODO
	  */
	private static MessageInfo returnJsonMsgs(MessageInfo messageInfo, int code, String msg, String status, boolean pass) {
		messageInfo.setCode(code);
		messageInfo.setMsg(msg);
		messageInfo.setStatus(status);
		messageInfo.setPass(pass);
		return messageInfo;
	}
	
	
}

