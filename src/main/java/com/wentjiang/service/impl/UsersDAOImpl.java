
package com.wentjiang.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wentjiang.db.MyHibernateSessionFactory;
import com.wentjiang.entity.Users;
import com.wentjiang.service.UsersDAO;

/*
@author  jiangwentao 
@E-mail  wentjiang@sina.com
@date    2016年6月27日 上午10:55:19 
*/
public class UsersDAOImpl implements UsersDAO {

	@Override
	public boolean usersLogin(Users users) {
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where username = ? and password = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, users.getUsername());
			query.setParameter(1, users.getPassword());
			@SuppressWarnings("unchecked")
			List<Users> list = query.list();
			// tx.commit();//提交事务
			if (list != null && list.size() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}

}
