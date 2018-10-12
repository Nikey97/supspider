package cn.kuqi.ServiceImpi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.kuqi.Mapper.AdminBackstageMapper;
import cn.kuqi.Pojo.ArticleClassfiy;
import cn.kuqi.Pojo.ArticleClassfiyExt;
import cn.kuqi.Pojo.MessageInfo;
import cn.kuqi.Pojo.Users;
import cn.kuqi.Service.AdminBackstageService;

@Service
public class AdminBackstageServiceImpi implements AdminBackstageService{

	@Autowired
	AdminBackstageMapper usersMapperExt;
	/*
	 * 后台管理系统 --> 后台登录
	 * 
	 * 
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
		
		ArticleClassfiyExt articleClassfiyExt=new ArticleClassfiyExt();
		
		List<ArticleClassfiy> list= usersMapperExt.QueryAllClassfiy();
		
		articleClassfiyExt.setData(list);
		
		articleClassfiyExt.setCode(0);
		
		articleClassfiyExt.setMsg("");
		
		articleClassfiyExt.setCount(list.size());
		
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
	
	
}
