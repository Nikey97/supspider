package cn.kuqi.Service;

import java.util.ArrayList;
import java.util.List;
import cn.kuqi.Pojo.Article;
import cn.kuqi.Pojo.ArticleClassfiy;
import cn.kuqi.Pojo.ArticleExt;
import cn.kuqi.Pojo.BlogInfoJoinTheme;
import cn.kuqi.Pojo.Bloginfo;
import cn.kuqi.Pojo.Link;
import cn.kuqi.Pojo.LinkExt;
import cn.kuqi.Pojo.MessageInfo;
import cn.kuqi.Pojo.Users;


public interface AdminBackstageService {
	
	//后台管理系统  --> 后台主页
	
	
	/**	后台管理系统 --> 后台登录
	 * 	需求分析：
	 * 		用户发送登录账号，后台响应执行登录是否成功。
	 * 		
	 * 		1.账号 密码
	 * 		2.判断账号是否是用户名或者邮箱 ， 都不是即返回用户不存在的Json
	 * */
	Integer QueryUserLoginInfo(String account,String psw) ;
	
	
	/**
	 * 后台管理系统 --> 查询全部
	 * 
	 * 需求分析：
	 * 		与前端的数据表格对接，必须按照表格的数据返回Json。
	 * */
	List<ArticleClassfiy> QueryAllArticleClassfiyService(Integer now, Integer max);
	 
	/**
	 * 后台管理系统 --> 查询分类记录数
	 * 
	 * 需求分析：
	 * 		与前端的数据表格对接，必须按照表格的数据返回Json。
	 * */
	Integer QueryCountArticleClassfiyService();
	
	 /**
	  * 后台管理系统 --> 查询单个分类
	  * 
	  * */
	ArticleClassfiy QueryOneArticleClassfiyService(Integer Number);
	
	 /**
	  * 后台管理-->添加分类
	  * 需求分析：
	  * 		controller接收添加的分类信息，在返回执行结果
	  * */
	Integer AddClassfiyService(String ClassfiyName,String ClassfiyRemark) ;
	 
	 /** 
	  * 后台管理-->文章 管理-->操作 
	  *  修改分类 
	  *
	  * */
	 Integer UpdataArticleClassfiyService(Integer Number , String ClassfiyName, String ClassfiyRemark) ;
	 
	 /**
	  * 后台管理-->文章 管理-->操作 
	  *  删除分类 
	  *
	  * */
	 MessageInfo DeleteArticleClassfiyService(ArrayList<Integer> classfiyList);
	 
	 /**
	  * 后台管理-->文章操作  查询所有文章
	  * 
	  * */
	 List<Article> QueryAllArticleService(Integer now, Integer max);
	 
	 /**
	  * 后台管理-->查询所有评论数
	  * 
	  * */
	 Integer QueryAllArticleCommentsService(Integer Number);
	 
	 /**
	  * 后台管理-->查询所有未发布文章
	  * 
	  * */
	 List<Article> QueryNotPublisArticleServices(Integer now, Integer max);
	 
	 /**
	  * 后台管理-->查询所有未发布文章
	  * 
	  * */
	 Integer QueryNotPublisArticleCountServices();
	 
	 /**
	  * 后台管理-->文章操作  查询所有文章记录数
	  * 
	  * */
	 Integer QueryAllCountArticleService();
	 
	 /**
	  * 后台管理-->文章操作  查询单篇文章
	  * 
	  * 
	  * */
	 Article QueryArticleByNumberService(Integer Number);
	 
	 
	 /**
	  * 后台管理-->文章删除
	  * 需求分析：
	  * 		Controller 接收要删除的文章编号， 再执行sql删除选择的编号
	  * */
	 String DeleteArticleByNumberService(Integer Number) ;
	 
	 /**
	  * 后台管理--> 文章修改
	  * 
	  * */
	 String UpdataArticleByNumberService(Integer Number,String Content);
	 
	 /**
	  * 后台管理--> 使用分类来查询所有文章
	  * 
	  * */
	 ArticleExt QueryArticleByClassfiyService(Integer ClassfiyNumber) ;
	 
	 /**
	  * 后台管理--> 发博客
	  * 
	  * */
	 String AddArticleService(Article article);
	 
	 /**
	  * 后台管理--> 友情链接    添加
	  * 
	  * */
	 Integer addLinkService(Link link) ;
	 
	 
	 /**
	  * 后台管理--> 友情链接    查询所有的链接或者是单条
	  * 
	  * */
	 List<Link> queryLinkService(Integer pager,Integer max);
	 
	 /**
	  * 后台管理--> 友情链接    删除友链
	  * 
	  * */
	 Integer deleteLinkService(Link link);
	 
	 /**
	  * 后台管理--> 友情链接    修改友链
	  * 
	  * */
	 Integer alterLinkService(Link link);
	 
	 /**
	  * 后台管理 -->用户综合条件查询
	  * 需求分析：
	  *			用户执行无数据请求，查询的是制定个数的用户。
	  *			有数据请求，查询符合条件的用户
	  * */
	 List<Users> queryUsersInfoByAllDataService(Users users);//综合条件查询
	 
	 MessageInfo deleteUserByIDService(List<Integer> list);//删除用户
	 
	 MessageInfo alterUserInfoByIdService(Users users);//修改用户信息
	 
	 List<Users> queryUsersInfoByAllService(Integer now,Integer max); //用户信息分页查询
	 
	 
	 
	 
	 /**
	  * 后台管理-->博客信息查询
	  * 	需求分析：
	  * 			1.进入页面请求响应博客信息，设置到表单显示。   信息查询接口
	  * 			2.修改信息		信息修改接口
	  * */
	 BlogInfoJoinTheme queryBlogInfoService();//查询博客
	 
	 Integer alterBlogInfoService(Bloginfo bloginfo);//修改博客信息
	 
}
