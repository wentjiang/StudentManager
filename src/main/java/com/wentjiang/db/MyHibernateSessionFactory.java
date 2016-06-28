
package com.wentjiang.db;
/*
@author  jiangwentao 
@E-mail  wentjiang@sina.com
@date    2016年6月27日 上午10:42:29 
*/

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class MyHibernateSessionFactory {

	private static SessionFactory sessionFactory;// 会话工厂
	private static int num = 0;

	// 构造方法私有
	private MyHibernateSessionFactory() {

	}

	// 共有静态方法,获得会话工程
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null && num == 0) {
			sessionFactory = new Configuration()
		            .configure() // configures settings from hibernate.cfg.xml
		            .buildSessionFactory();
			num++;
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}
}
