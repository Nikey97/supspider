package cn.kuqi.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.kuqi.Pojo.Article;
import cn.kuqi.Pojo.ArticleClassfiy;
import cn.kuqi.Pojo.ArticleExt;
import cn.kuqi.Pojo.BlogInfoJoinTheme;
import cn.kuqi.Pojo.Bloginfo;
import cn.kuqi.Pojo.Link;
import cn.kuqi.Pojo.Theme;
import cn.kuqi.Pojo.Users;

public interface AdminBackstageMapper {
		
	/*	后台管理系统 --> 后台登录
	 * 	需求分析：
	 * 		用户发送登录账号，后台响应执行登录是否成功。
	 * 		
	 * 		1.账号 密码
	 * 		2.判断账号是否是用户名或者邮箱 ， 都不是即返回用户不存在的Json
	 * */
	Users QueryUserInfoByName(String username) ;
	
	Users QueryUserInfoByEmail(String email) ;
	
	
	/*	后台管理系统--> 查询分类
	 * 
	 * 	需求分析：
	 * 			执行接口能查询所有的结果
	 * */
	List<ArticleClassfiy> QueryAllClassfiy(@Param("now") Integer now, @Param("max") Integer max);
	
	/*	后台管理系统--> 查询分类总数
	 * 
	 * 	需求分析：
	 * 			执行接口能查询分类总数
	 * */
	Integer QueryCountClassfiy();
	
	/*	后台管理系统--> 查询单个分类
	 * 
	 * 	需求分析：
	 * 			执行接口能查询所有的结果
	 * */
	ArticleClassfiy QueryOneClassfiy(Integer Number);
	
	/*  后台管理 --> 添加分类
	 * 	
	 * 
	 * */
	Integer InsertClassfiy(@Param("Name")String ClassfiyName,@Param("Remark")String ClassfiyRemark) ;
	
	/*
	 * 	后台管理--> 修改分类    修改查询分类
	 * 	
	 * 	需求分析：
	 * 		接收前台的分类编号信息，再查询返回分类信息
	 * 		
	 * 
	 * */
	ArticleClassfiy SelectArtcleClassfiyByNumber(@Param("Number")Integer Number) ;
	
	
	/*
	 *  后台管理--> 修改分类
	 * 
	 * 	需求分析：
	 * 
	 * 		contorller接收修改后的信息，与查询查来的信息做对比。
	 * 		1.一样返回未修改不更新数据库
	 * 		2.有变化修改数据库
	 * */
	Integer UpdataArtcleClassfiyByNumber(@Param("Number")Integer Number,@Param("ClassfiyName")String ClassfiyName,@Param("ClassfiyRemark")String ClassfiyRemark) ;
	

	/*	后台管理--> 删除分类
	 * 
	 * 	需求分析:
	 * 			controller接收前台的Number值，Dao接收执行删除语句。再返回执行结果
	 * 		
	 * */
	Integer DeleteArtcleClassfiyByNumber(@Param("number") Integer number);
	
	/*
	 *  后台管理--> 文章操作    查询所有文章 
	 * 	
	 * */
	List<Article> QueryAllArticle(@Param("now") Integer now, @Param("max") Integer max);
	
	/*
	 *  后台管理--> 文章操作    查询所有未发布的文章 
	 * 	
	 * */
	List<Article> QueryAllDraft(@Param("now") Integer now, @Param("max") Integer max);
	
	/*
	 *  后台管理--> 文章操作    查询所有未发布的文章总记录数 
	 * 	
	 * */
	Integer QueryAllDraftCount();
	
	/*
	 *  后台管理--> 文章操作    查询所有文章记录数
	 * 	
	 * */
	Integer QueryCountArticle();
	
	/*
	 *  后台管理--> 文章操作    查询单篇文章 
	 * 	
	 * */
	Article QueryArticleByNumber(@Param("Number")Integer Number);
	
	/*
	 *  后台管理--> 文章操作    查询文章所有评论记录数 
	 * 	
	 * */
	Integer QueryArticleAllComment(@Param("Number") Integer Number);
	
	/*
	 *  后台管理--> 删除文章
	 * 
	 * */
	Integer DeleteArticleByNumber(@Param("Number")Integer Number) ;
	
	/*
	 *  后台管理--> 修改文章
	 * */
	Integer UpdataArticleByNumber(@Param("Number")Integer Number,@Param("Content")String Content);
	
	
	/*
	 * 	 后台管理--> 文章操作    按分类查询文章
	 * 
	 * */
	ArticleExt QueryArticleByClassfiy(@Param("ClassfiyNumber")Integer ClassfiyNumber);	
	/*
	 * 	后台管理--> 文章添加
	 * 	需求分析：
	 * 			controllr 接收文章标题、分类、内容，再执行插入操作。
	 * 			返回执行结果
	 * */
	Integer AddArticle(Article article);
	
	/*
	 *  后台管理--> 友情链接    添加
	 * 
	 * 		需求：插入链接	
	 * 			返回添加链接	
	 * */
	Integer addLink(Link link);//添加
	
	List<Link> queryLinks(@Param("now") Integer now, @Param("max") Integer max, 
			@Param("lName") String lName, @Param("lLink") String lLink, @Param("lNumber") Integer lNumber);//查询所有友链
	
	List<Link> queryAllLinks();//查询所有连接条数
	
	Integer deleteLinkByNumber(Integer Number);//删除友链信息
	
	Integer alterLinkByNumber(Link link);//修改友链信息
	
	
	
	/*
	 * 后台管理--> 用户管理 --> 用户综合查询
	 * 
	 * 需求分析：
	 * 		1.前台提交实体类数据（json）,controller接收后执行Service查询数据库。
	 * 		2.查询内容：用户ID、Email、用户名、用户昵称
	 * */
	List<Users> queryUsersInfoByAllData(Users users) ;//综合条件查询
	
	Users QueryUserInfoByID(Users users);//通过ID查单个用户
	
	Integer DeleteUserByUID(@Param("ID") Integer UID) ;//删除用户
	
	Integer AlterUserInfo(Users users);//修改用户
	
	List<Users> queryAllUser(@Param("now") Integer now, @Param("max") Integer max);//用户信息分页查询
		
	
	/*
	 * 博客管理-->信息操作 
	 * 	需求分析：
	 * 			1.进入页面请求响应博客信息，设置到表单显示。   信息查询接口
	 * 			2.修改信息		信息修改接口
	 * */
	BlogInfoJoinTheme queryBlogInfoByNumber() ;//查询博客信息
	
	Integer alterBlogInfoByNumber(Bloginfo bloginfo) ;//修改博客信息
	
	/*
	 * 博客管理-->主题操作
	 * 需求分析：
	 * 		1.上传文件： 存入上传的路径
	 * 		2.修改主题
	 * 		3.删除主题
	 * */
	Integer InsertBlogTheme(Theme theme);//存入上传的主体信息
	
}