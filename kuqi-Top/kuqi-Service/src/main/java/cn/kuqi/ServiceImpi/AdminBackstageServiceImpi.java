package cn.kuqi.ServiceImpi;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.kuqi.Service.AdminBackstageService;
import cn.kuqi.DateUtil.MyDateUtils;
import cn.kuqi.Mapper.AdminBackstageMapper;
import cn.kuqi.Pojo.Article;
import cn.kuqi.Pojo.ArticleClassfiy;
import cn.kuqi.Pojo.ArticleExt;
import cn.kuqi.Pojo.BlogInfoJoinTheme;
import cn.kuqi.Pojo.Bloginfo;
import cn.kuqi.Pojo.Link;
import cn.kuqi.Pojo.LinkExt;
import cn.kuqi.Pojo.MessageInfo;
import cn.kuqi.Pojo.Users;

@Service
@Transactional
public class AdminBackstageServiceImpi implements AdminBackstageService{

	@Autowired
	AdminBackstageMapper usersMapperExt;
	
	/*
	 * 后台管理系统 --> 后台登录
	 * 
	 * */
	public Integer QueryUserLoginInfo(String account, String psw) {
		
		int LOGIN_STATUS_PSWERREO = 1;
		
		int LOGIN_STATUS_USERESERREO = 2;
		
		int LOGIN_STATUS_SUCCESS = 0;
		
		Users data_name = usersMapperExt.QueryUserInfoByName(account);
		
		Users data_email = usersMapperExt.QueryUserInfoByEmail(account);
		
		//使用的账号是用户名
		if (data_name != null) {
			
			if (data_name.getuPsw().equals(psw)) {
				//密码正确
				return LOGIN_STATUS_SUCCESS;
			}else {
				//密码有误
				return LOGIN_STATUS_PSWERREO;
			}
		}
		
		//使用的账号是邮箱
		if (data_email != null) {
			
			if (data_email.getuPsw().equals(psw)) {
				//密码正确
				return LOGIN_STATUS_SUCCESS;
			}else {
				//密码有误
				return LOGIN_STATUS_PSWERREO;
			}
		}
		return LOGIN_STATUS_USERESERREO;
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: QueryAllArticleClassfiyService
	  * @Description: 查询所有分类  
	  * @return return_type    
	  * @date: 2018年11月29日 下午3:21:22  
	  * @todo: TODO
	  */
	public List<ArticleClassfiy> QueryAllArticleClassfiyService(Integer now, Integer max) {
		return usersMapperExt.QueryAllClassfiy(now,max);
	}
	
	public Integer QueryCountArticleClassfiyService() {
		return usersMapperExt.QueryCountClassfiy();
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName:QueryOneArticleClassfiyService
	  * @Description: 查询单个分类  
	  * @return ArticleClassfiy     
	  * @date: 2018年11月29日 下午4:11:24  
	  * @todo: TODO
	  */
	public ArticleClassfiy QueryOneArticleClassfiyService(Integer Number) {
		return usersMapperExt.QueryOneClassfiy(Number);
	}

	/**  
	  * @user: Nikey 
	  * @MethodName: AddClassfiyService
	  * @Description: 添加文章分类  
	  * @return return_type     
	  * @date: 2018年11月29日 下午1:38:00  
	  * @todo: TODO
	  */
	@Transactional(readOnly=true)
	public Integer AddClassfiyService(String ClassfiyName, String ClassfiyRemark) {
		return usersMapperExt.InsertClassfiy(ClassfiyName, ClassfiyRemark);
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: UpdataArticleClassfiyService
	  * @Description: 修改文章分类   
	  * @return return_type     
	  * @date: 2018年11月29日 下午5:29:05  
	  * @todo: TODO
	  */
	public Integer UpdataArticleClassfiyService(Integer Number, String ClassfiyName, String ClassfiyRemark) {
		int msgs;
		ArticleClassfiy articleClassfiy = usersMapperExt.SelectArtcleClassfiyByNumber(Number);
		if (ClassfiyName.equals(articleClassfiy.getAcClassfiyname()) && ClassfiyRemark.equals(articleClassfiy.getAcRemark()))
		{
			return 2;	
		}
		else
		{
			int i = usersMapperExt.UpdataArtcleClassfiyByNumber(Number, ClassfiyName, ClassfiyRemark);
			if (i == 1) 
			{
				msgs = 1;
			}
			else 
			{
				msgs = 0;
			}
			return msgs;
		}
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName:DeleteArticleClassfiyService
	  * @Description:删除分类（支持批量）   
	  * @return return_type     
	  * @date: 2018年11月29日 下午9:20:39  
	  * @todo: TODO
	  */
	public MessageInfo DeleteArticleClassfiyService(ArrayList<Integer> classfiyList) {
		int success = 0, error = 0;
		MessageInfo msg = new MessageInfo();
		for (Integer number : classfiyList) {
			System.out.println(number);
			int i = usersMapperExt.DeleteArtcleClassfiyByNumber(number);
			if (i == 1)
				success++;
			else 
				error++;
		}
		msg.setCode(0);
		msg.setMsg("总删除任务:"+classfiyList.size()+"个，成功："+success+"，失败："+error);
		return msg;
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: QueryAllArticleService
	  * @Description: 查询文章信息   （分页）
	  * @return Article     
	  * @date: 2018年12月3日 下午9:42:01  
	  * @todo: TODO
	  */
	public List<Article> QueryAllArticleService(Integer now, Integer max) {
		List<Article> article = usersMapperExt.QueryAllArticle(now,max);
		return article;
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: QueryAllArticleService
	  * @Description: 查询文章所有记录数，用于提供给页面分页  
	  * @return Integer     
	  * @date: 2018年12月3日 下午9:53:24  
	  * @todo: TODO
	  */
	public Integer QueryAllCountArticleService() {
		return usersMapperExt.QueryCountArticle();
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: QueryArticleByNumberService
	  * @Description: 查询单篇文章  
	  * @return Article     
	  * @date: 2018年12月4日 上午11:50:17  
	  * @todo: TODO
	  */
	public Article QueryArticleByNumberService(Integer Number) {
		Article article = usersMapperExt.QueryArticleByNumber(Number);
		return article;
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: DeleteArticleByNumberService
	  * @Description: 删除单篇文章  
	  * @return return_type     
	  * @date: 2018年12月4日 上午11:50:17  
	  * @todo: TODO
	  */
	public String DeleteArticleByNumberService(Integer Number) {
		String msgs = null;
		Article article = usersMapperExt.QueryArticleByNumber(Number);
		if (article != null) {
			int i = usersMapperExt.DeleteArticleByNumber(Number);
			if (i == 1) {
				msgs = "删除成功";
			}else {
				msgs = "删除失败";
			}
		}else {
			msgs = "文章不存在";
		}
		return msgs;
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName:
	  * @Description: 查询文章所有的评论记录数  
	  * @return int     
	  * @date: 2018年12月4日 下午2:56:55  
	  * @todo: TODO
	  */
	public Integer QueryAllArticleCommentsService(Integer Number) {
		return usersMapperExt.QueryArticleAllComment(Number);
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: QueryNotPublisArticleServices
	  * @Description: 查询所有未发布的文章  
	  * @return List<Article>     
	  * @date: 2018年12月6日 上午9:45:26  
	  * @todo: TODO
	  */
	public List<Article> QueryNotPublisArticleServices(Integer now, Integer max) {
		return usersMapperExt.QueryAllDraft(now, max);
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: QueryNotPublisArticleCountServices
	  * @Description: 查询未阅读文章的总记录数  
	  * @return Integer     
	  * @date: 2018年12月6日 上午9:55:16  
	  * @todo: TODO
	  */
	public Integer QueryNotPublisArticleCountServices() {
		return usersMapperExt.QueryAllDraftCount();
	}
	
	/*  后台管理-->文章 管理-->操作     修改单篇文章    */
	public String UpdataArticleByNumberService(Integer Number, String Content) {
		
		int i = usersMapperExt.UpdataArticleByNumber(Number, Content);//执行操作
		
		if (i == 1) {
			return "{\"code\":0,\"msg\":\"修改成功\",}";
		}else {
			return "{\"code\":1,\"msg\":\"修改失败\",}";
		}
	}
	
	/*  后台管理-->文章 管理-->操作   使用分类查询单篇文章    */
	public ArticleExt QueryArticleByClassfiyService(Integer ClassfiyNumber) {
		ArticleExt articleExt = usersMapperExt.QueryArticleByClassfiy(ClassfiyNumber);
		articleExt.setCode(0);
		articleExt.setMsg("");
		articleExt.setCount(articleExt.getData().size());
		return articleExt;
	}
	
	/*  后台管理-->文章 管理-->操作   发博客   */
	public String AddArticleService(Article article) {
		MyDateUtils myDateUtils = new MyDateUtils();
		String time = myDateUtils.getSystemNowTime("yyyy年MM月dd日 HH时mm分ss秒");//获取时间
		
		article.setaViewcount(0);
		article.setaPraise(0);
		article.setaTrample(0);
		article.setaCollectedcount(0);
		article.setaPublishtime(time);
		int i = usersMapperExt.AddArticle(article);//插入到数据库
		
		if (i == 1) {
			return "发布成功";
		}else{
			return "发布失败";
		}
	}
	
	/*  后台管理-->博客管理 -->友情操作    添加   */
	public Integer addLinkService(Link link) {
		MyDateUtils myDateUtils = new MyDateUtils();
		List<Link> linkList = usersMapperExt.queryLinks(0,5,link.getlName(),null,null);
		if (linkList.size() != 0) {
			return 0;
		}//有重复的友链
		String time = myDateUtils.getSystemNowTime("yyyy年MM月dd日 HH时mm分ss秒");//获取时间
		link.setlAddtime(time);
		link.setlClickcount(0);
		link.setlShow(link.getlShow());
		return usersMapperExt.addLink(link);
	}
	
	/*  后台管理-->博客管理 -->友情操作    分页查询单条链接或者多条   */
	public List<Link> queryLinkService(Integer pager,Integer max) {
		return usersMapperExt.queryLinks(pager,max,null,null,null);
	}
	
	/*  后台管理-->博客管理 -->友情操作    分页查询所有的链接   */
	public Integer queryAllLinkService() {
		List<Link> list = usersMapperExt.queryAllLinks();
		return list.size();
	}
	
	/*  后台管理-->博客管理 -->友情操作    分页查询指定的链接或者多条   */
	public List<Link> queryOneLinkService(Integer Number) {
		return usersMapperExt.queryLinks(0,5,null,null,Number);
	}
	
	/* 后台管理-->博客管理 -->友情操作    删除友链  */
	public Integer deleteLinkService(Link link) {
		List<Link> listLink = usersMapperExt.queryLinks(0,5,link.getlName(),null,null);
		if (listLink.size() != 0) {
			return usersMapperExt.deleteLinkByNumber(link.getlNumber());
		}else {
			return 0;
		}
	}
	
	/* 后台管理-->博客管理 -->友情操作    修改友链  */
	
	public Integer alterLinkService(Link link) {
		int i;
		List<Link> listLink = usersMapperExt.queryLinks(0,5,null,null,link.getlNumber());
		if (listLink.size() != 0) {
			i = usersMapperExt.alterLinkByNumber(link);
		}else {
			i = 0;
		}
		return i;
	}
	
	/* 后台管理-->用户管理 -->操作   查询用户*/
	public List<Users> queryUsersInfoByAllDataService(Users users) {
		return usersMapperExt.queryUsersInfoByAllData(users);
	}
	
	/* 后台管理-->用户管理 -->操作   分页查询用户 */
	public List<Users> queryUsersInfoByAllService(Integer now, Integer max) {
		return usersMapperExt.queryAllUser(now, max);
	}
	
	
	/* 后台管理-->用户管理 -->操作   删除用户*/
	public MessageInfo DeleteUserByIDService(Users users) {
		MessageInfo messageInfo = new MessageInfo();
		
		List<Users> data = usersMapperExt.queryUsersInfoByAllData(users);
		
		if (data.size() != 0) {
			int i = usersMapperExt.DeleteUserByUID(users.getuId());
			if (i == 1) {
				messageInfo.setCode(0);
				messageInfo.setMsg("删除成功");
			}else {
				messageInfo.setCode(1);
				messageInfo.setMsg("删除失败, 系统执行异常");
			}
			return messageInfo;
		}else {
			messageInfo.setCode(2);
			messageInfo.setMsg("删除失败, 删除的用户不存在");
			return messageInfo;
		}
	}
	
	/* 后台管理-->用户管理 -->操作   删除用户*/
	public MessageInfo AlterUserInfoByIdService(Users users) {
		MessageInfo messageInfo = new MessageInfo();
		Users data = usersMapperExt.QueryUserInfoByID(users);
		
		if (data != null) {
			int i = usersMapperExt.AlterUserInfo(users);
			
			if (i == 1) {
				messageInfo.setCode(0);
				messageInfo.setMsg("修改成功");
			}else {
				messageInfo.setCode(1);
				messageInfo.setMsg("修改失败，系统执行异常");
			}
			return messageInfo;
		}else {
			messageInfo.setCode(2);
			messageInfo.setMsg("修改失败，修改的用户信息不存在");
			return messageInfo;
		}
	}
	
	/* 后台管理-->博客管理  查询信息*/
	public BlogInfoJoinTheme queryBlogInfoService() {
		return usersMapperExt.queryBlogInfoByNumber();
	}
	
	/* 后台管理-->博客管理 修改信息*/
	public Integer alterBlogInfoService(Bloginfo bloginfo) {
		return usersMapperExt.alterBlogInfoByNumber(bloginfo);
	}

	
}
