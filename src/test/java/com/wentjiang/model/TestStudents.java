
package com.wentjiang.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.wentjiang.entity.Students;

/*
@author  jiangwentao 
@E-mail  wentjiang@sina.com
@date    2016年6月27日 上午10:13:11 
*/
public class TestStudents {
	@Test
	public void testSchemaExport() {
		// 创建配置对象
		Configuration configuration = new Configuration().configure();
		// 创建服务注册对象
		// ServiceRegistry serviceRegistry = new
		// ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		// //创建sessionfactory
		// SessionFactory sessionFactory =
		// configuration.buildSessionFactory(serviceRegistry);
		// //创建session对象
		// Session session = sessionFactory.getCurrentSession();
		// 创建schemaexport对象
		SchemaExport export = new SchemaExport(configuration);

		export.create(true, true);
	}

	// 添加测试数据
	@Test
	public void testSaveStudents() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Students students = new Students("s0000001", "jiang", "man", new Date(), "dizhi");
		Students students1 = new Students("s0000002","wen","man",new Date(),"dizhi"); 
		Students students2 = new Students("s0000003","tao","man",new Date(),"dizhi"); 
		session.save(students);
		session.save(students1);
		session.save(students2);
		tx.commit();
		sessionFactory.close();
		
	}
}
