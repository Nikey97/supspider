package cn.kuqi.ServiceImpi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.kuqi.Service.AdminBackstageService;
import cn.kuqi.DateUtil.MyDateUtils;
import cn.kuqi.Mapper.AdminBackstageMapper;
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


@Service
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

	/*  后台管理-->文章 管理-->操作        查询所有分类    */
	public ArticleClassfiyExt QueryAllArticleClassfiyService() {
		ArticleClassfiyExt articleClassfiyExt = new ArticleClassfiyExt(); 
		List<ArticleClassfiy> list= usersMapperExt.QueryAllClassfiy();
		articleClassfiyExt.setData(list);
		articleClassfiyExt.setCode(0);
		articleClassfiyExt.setMsg("");
		articleClassfiyExt.setCount(articleClassfiyExt.getData().size());
		return articleClassfiyExt;
	}

	/*  后台管理-->文章 管理-->操作        添加分类    */
	public MessageInfo AddClassfiyService(String ClassfiyName, String ClassfiyRemark) {
		
		MessageInfo msg = new MessageInfo(); 
		
		int i = usersMapperExt.InsertClassfiy(ClassfiyName, ClassfiyRemark);
		
		if (i == 1) {
			msg.setCode(i);
			msg.setMsg("添加成功");
			return msg;
		}else {
			msg.setCode(i);
			msg.setMsg("添加失败，请联系管理员。");
			return msg;
		}
	}
	
	
	/*  后台管理-->文章 管理-->操作        修改查询分类    */
	public ArticleClassfiy SelectArticleClassfiyService(Integer Number) {
		
		ArticleClassfiy articleClassfiy = usersMapperExt.SelectArtcleClassfiyByNumber(Number);
		//容错判断
		return articleClassfiy;
	}
	
	
	/*  后台管理-->文章 管理-->操作        修改分类    */
	public MessageInfo UpdataArticleClassfiyService(Integer Number, String ClassfiyName, String ClassfiyRemark) {
		MessageInfo msg = new MessageInfo();
		
		ArticleClassfiy articleClassfiy = usersMapperExt.SelectArtcleClassfiyByNumber(Number);
		
		if (ClassfiyName.equals(articleClassfiy.getAcClassfiyname()) && ClassfiyRemark.equals(articleClassfiy.getAcRemark())) {
			msg.setCode(2);
			msg.setMsg("拒接访问，您的操作没有修改内容");
			return msg;	
		}else {
			int i = usersMapperExt.UpdataArtcleClassfiyByNumber(Number, ClassfiyName, ClassfiyRemark);
			if (i == 1) {
				msg.setCode(0);
				msg.setMsg("修改成功");
			}else {
				msg.setCode(1);
				msg.setMsg("修改失败，请联系管理员");
			}
			return msg;
		}
	}
	
	/*  后台管理-->文章 管理-->操作        删除分类    */
	public MessageInfo DeleteArticleClassfiyService(Integer Number) {
		MessageInfo msg = new MessageInfo();
		
		ArticleClassfiy articleClassfiy = usersMapperExt.SelectArtcleClassfiyByNumber(Number);
		
		if (articleClassfiy != null) {
			int i = usersMapperExt.DeleteArtcleClassfiyByNumber(Number);
			if (i == 1) {
				msg.setCode(0);
				msg.setMsg("删除成功");
			}else {
				msg.setCode(1);
				msg.setMsg("删除失败，请联系管理员");
			}
			return msg;
		}else {
			msg.setCode(2);
			msg.setMsg("拒接访问，删除的分类不存在");
			return msg;
		}
	}
	
	/*  后台管理-->文章 管理-->操作     查询所有文章    */
	public ArticleExt QueryAllArticleService() {
		ArticleExt articleExt = usersMapperExt.QueryAllArticle();
		articleExt.setCode(0);
		articleExt.setMsg("");
		articleExt.setCount(articleExt.getData().size());
		return articleExt;
	}
	
	/*  后台管理-->文章 管理-->操作     查询单篇文章  */
	public Article QueryArticleByNumberService(Integer Number) {
		Article article = usersMapperExt.QueryArticleByNumber(Number);
		return article;
	}
	
	
	/*  后台管理-->文章 管理-->操作     删除单篇文章    */
	public MessageInfo DeleteArticleByNumberService(Integer Number) {
		MessageInfo msg = new MessageInfo();
		
		Article article = usersMapperExt.QueryArticleByNumber(Number);
		
		if (article != null) {
			int i = usersMapperExt.DeleteArticleByNumber(Number);
			if (i == 1) {
				msg.setCode(0);
				msg.setMsg("删除成功");
			}else {
				msg.setCode(1);
				msg.setMsg("删除失败");
			}
			return msg;
		}else {
			msg.setCode(2);
			msg.setMsg("拒接访问， 删除的文章不存在");
			return msg;
		}
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
	public MessageInfo AddLinkService(Link link) {
		MessageInfo messageInfo = new MessageInfo();
		MyDateUtils myDateUtils = new MyDateUtils();
		String time = myDateUtils.getSystemNowTime("yyyy年MM月dd日 HH时mm分ss秒");//获取时间
		link.setlAddtime(time);
		link.setlClickcount(0);
		int i = usersMapperExt.AddLink(link);
		if (i == 1) {
			messageInfo.setCode(0);
			messageInfo.setMsg("添加成功");
			return messageInfo;
		}else {
			messageInfo.setCode(0);
			messageInfo.setMsg("添加失败");
			return messageInfo;
		}
	}
	
	/*  后台管理-->博客管理 -->友情操作    查询所有的链接或者多条   */
	public LinkExt QueryLinkService(Link link) {
		
		if (link.getlNumber() != null) {
			LinkExt linkExt = new LinkExt();
			List<Link> datalist = new ArrayList<Link>();
			Link data = usersMapperExt.QueryLinkOne(link.getlNumber());
			datalist.add(data);
			linkExt.setData(datalist);
			linkExt.setCode(0);
			linkExt.setMsg("");
			linkExt.setCount(datalist.size());
			return linkExt;//返回单条链接信息
		}else {
			LinkExt linkExt = new LinkExt();
			List<Link> data= usersMapperExt.QueryLinks();
			linkExt.setData(data);
			linkExt.setCode(0);
			linkExt.setCount(data.size());
			linkExt.setMsg("");
			return linkExt;//返回所有多条信息
		}
	}
	
	/* 后台管理-->博客管理 -->友情操作    删除友链  */
	public MessageInfo DeleteLinkService(Link link) {
		MessageInfo messageInfo = new MessageInfo(); 
		Link data = usersMapperExt.QueryLinkOne(link.getlNumber());
		
		if (data != null) {
			int i = usersMapperExt.DeleteLinkByNumber(link.getlNumber());
			if (i == 1) {
				messageInfo.setCode(0);
				messageInfo.setMsg("删除成功");
				messageInfo.setStatus("");
			}else {
				messageInfo.setCode(1);
				messageInfo.setMsg("删除失败");
				messageInfo.setStatus("");
			}
			return messageInfo;
		}else {
			messageInfo.setCode(2);
			messageInfo.setMsg("拒绝访问，删除的友链不存在");
			messageInfo.setStatus("");
			return messageInfo;
		}
	}
	
	/* 后台管理-->博客管理 -->友情操作    修改友链  */
	public MessageInfo AlterLinkService(Link link) {
		MessageInfo messageInfo = new MessageInfo(); 
		Link data = usersMapperExt.QueryLinkOne(link.getlNumber());//查询是否存在Link
		
		if (data != null) {
			if (link.getlName().equals(data.getlName()) && link.getlLink().equals(data.getlLink())) {
				messageInfo.setCode(3);
				messageInfo.setMsg("系统检测到并没有修改内容，无法更新操作");
			}else {
				int i = usersMapperExt.AlterLinkByNumber(link);
				if (i == 1) {
					messageInfo.setCode(0);
					messageInfo.setMsg("修改成功");
				}else {
					messageInfo.setCode(1);
					messageInfo.setMsg("修改成功");
				}
			}
			return messageInfo;
		}else {
			messageInfo.setCode(2);
			messageInfo.setMsg("拒绝访问，修改的链接不存在");
			return messageInfo;
		}
	}
	
	/* 后台管理-->博客管理 -->友情操作    修改博客信息 */
	public Bloginfo AlterBlogInfoByNumber(Bloginfo bloginfo, MessageInfo messageInfo) {
		if (bloginfo.getBiNumber() == 1) {
			
			return null;
		}else {
			Bloginfo data = usersMapperExt.QueryBlogInfoByNumber();
			return data;
		}
	}
	
	/* 后台管理-->用户管理 -->操作   查询用户*/
	public UsersExt QueryUsersInfoByAllDataService(Users users) {
		UsersExt usersExt = new UsersExt(); 
		List<Users> data = usersMapperExt.QueryUsersInfoByAllData(users);
		usersExt.setData(data);
		usersExt.setCode(0);
		usersExt.setCount(data.size());
		usersExt.setMsg("");
		return usersExt;
	}
	
	/* 后台管理-->用户管理 -->操作   删除用户*/
	public MessageInfo DeleteUserByIDService(Users users) {
		MessageInfo messageInfo = new MessageInfo();
		
		List<Users> data = usersMapperExt.QueryUsersInfoByAllData(users);
		
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
	public Bloginfo QueryBlogInfoService() {
		Bloginfo bloginfo = usersMapperExt.QueryBlogInfoByNumber();
		return bloginfo;
	}
	
	/* 后台管理-->博客管理 修改信息*/
	public MessageInfo AlterBlogInfoService(Bloginfo bloginfo) {
		MessageInfo messageInfo = new MessageInfo();
		int i = usersMapperExt.AlterBlogInfoByNumber(bloginfo);
		if (i == 1) {
			messageInfo.setCode(0);
			messageInfo.setMsg("修改成功");
		}else {
			messageInfo.setCode(0);
			messageInfo.setMsg("修改失败，系统执行异常");
		}
		return messageInfo;
	}
}
