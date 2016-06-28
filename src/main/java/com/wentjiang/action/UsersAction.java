
package com.wentjiang.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.wentjiang.entity.Users;
import com.wentjiang.service.UsersDAO;
import com.wentjiang.service.impl.UsersDAOImpl;

/*
@author  jiangwentao 
@E-mail  wentjiang@sina.com
@date    2016年6月27日 下午3:47:20 
*/
public class UsersAction extends SuperAction implements ModelDriven<Users>{

	private static final long serialVersionUID = 1L;
	private Users user =new Users();
	//用户登录动作
	public String login(){
		UsersDAO usersDAO = new UsersDAOImpl();
		if (usersDAO.usersLogin(user)) {
			//在session中保存登录成功的用户名
			System.out.println(user.getUsername());
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}else{
			return "login_failure";
		}
	}
	@SkipValidation
	//用户注销方法
	public String logout(){
		if (session.getAttribute("loginUserName")!=null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	public Users getModel(){
		return this.user;
	}
//	@Override
//	public void validate(){
//		//用户名不能为空
//		if ("".equals(user.getUsername().trim())) {
//			this.addFieldError("usernameError", "用户名不能为空");
//		}
//		if(user.getPassword().length()<6){
//			this.addFieldError("passwordError", "密码长度不少于6位");
//		}
//	}
	
	
}
