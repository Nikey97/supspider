/**
 * 
 */
package cn.kuqi.Service;

import cn.kuqi.Pojo.ArticleClassfiy;
import cn.kuqi.Pojo.ArticleClassfiyExt;
import cn.kuqi.Pojo.MessageInfo;

/**
 * @author Nikey
 *
 */
public interface AdminBackstageService {
		
	//后台管理系统  --> 后台主页
	
	
	/*	后台管理系统 --> 后台登录
	 * 	需求分析：
	 * 		用户发送登录账号，后台响应执行登录是否成功。
	 * 		
	 * 		1.账号 密码
	 * 		2.判断账号是否是用户名或者邮箱 ， 都不是即返回用户不存在的Json
	 * */
	Integer QueryUserLoginInfo(String account,String psw) ;
	
	
	/*
	 * 后台管理系统 --> 查询全部
	 * 
	 * 需求分析：
	 * 		与前端的数据表格对接，必须按照表格的数据返回Json。
	 * 
	 * 
	 * */
	 ArticleClassfiyExt QueryAllArticleClassfiyService();
	 
	 
	 /*
	  * 后台管理-->添加分类
	  * 需求分析：
	  * 		controller接收添加的分类信息，在返回执行结果
	  * 
	  * */
	 MessageInfo AddClassfiyService(String ClassfiyName,String ClassfiyRemark) ;
	 
	 
	 /*
	  * 后台管理-->修改查询分类
	  * 
	  * */
	 ArticleClassfiy SelectArticleClassfiyService(Integer Number);
	 
	 
	 /* 
	  * 后台管理-->文章 管理-->操作 
	  *  修改分类 
	  *
	  * */
	 MessageInfo UpdataArticleClassfiyService(Integer Number , String ClassfiyName, String ClassfiyRemark) ;
	 
	 /* 
	  * 后台管理-->文章 管理-->操作 
	  *  删除分类 
	  *
	  * */
	 MessageInfo DeleteArticleClassfiyService(Integer Number) ;
}
