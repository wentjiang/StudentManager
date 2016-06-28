
package com.wentjiang.service;

import com.wentjiang.entity.Users;

/*
@author  jiangwentao 
@E-mail  wentjiang@sina.com
@date    2016年6月27日 上午10:55:57 
*/
//用户业务逻辑接口
public interface UsersDAO {

	// 用户登录方法
	public boolean usersLogin(Users users);
}
