package cn.kuqi.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.kuqi.Pojo.Article;
import cn.kuqi.Pojo.ArticleClassfiy;
import cn.kuqi.Pojo.ArticleClassfiyExt;
import cn.kuqi.Pojo.ArticleExt;
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
	List<ArticleClassfiy> QueryAllClassfiy();
	
	
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
	Integer DeleteArtcleClassfiyByNumber(@Param("Number")Integer Number);
	
	/*
	 *  后台管理--> 文章操作    查询所有文章 
	 * 	
	 * */
	ArticleExt QueryAllArticle();
	
	/*
	 *  后台管理--> 文章操作    查询单篇文章 
	 * 	
	 * */
	Article QueryArticleByNumber(@Param("Number")Integer Number);
	
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
	
}
