
package com.wentjiang.service.impl;
/*
@author  jiangwentao 
@E-mail  wentjiang@sina.com
@date    2016年6月27日 上午11:03:55 
*/

import org.junit.Assert;
import org.junit.Test;

import com.wentjiang.entity.Users;
import com.wentjiang.service.UsersDAO;

public class TestUserDAOImpl {
	@Test
	public void testUsersLogin(){
		Users u = new Users(1, "wentjiang","wentjiang");
		UsersDAO usersDAO = new UsersDAOImpl();
		Assert.assertEquals(true, usersDAO.usersLogin(u));
	}
}
