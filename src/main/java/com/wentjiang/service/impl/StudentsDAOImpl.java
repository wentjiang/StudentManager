
package com.wentjiang.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wentjiang.db.MyHibernateSessionFactory;
import com.wentjiang.entity.Students;
import com.wentjiang.service.StudentsDAO;

/*
@author  jiangwentao 
@E-mail  wentjiang@sina.com
@date    2016年6月27日 下午8:14:47 
*/
public class StudentsDAOImpl implements StudentsDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Students> queryAllStudents() {
		Transaction tx = null;
		List<Students> list = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql = "from Students";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return list;
		} finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public Students queryStudentsBySid(String sid) {
		Transaction tx = null;
		Students students = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			students = (Students) session.get(Students.class, sid);
			tx.commit();
			return students;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return students;
		}finally{
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public boolean addStudents(Students s) {
		s.setSid(getNewSid());
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		}finally{
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public boolean updateStudents(Students s) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		}finally {
			if (tx!=null) {
				tx=null;
			}
		}
		
	}

	@Override
	public boolean deleteStudents(String sid) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Students students = (Students) session.get(Students.class, sid);
			session.delete(students);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		}finally{
			if (tx!=null) {
				tx=null;
			}
		}
	}
	
	//生成学生的学号
	private String getNewSid(){
		Transaction tx=null;
		String hql = "";
		String sid = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//获得当前最大编号
			hql = "select max(sid) from Students";
			Query query = session.createQuery(hql);
			sid = (String) query.uniqueResult();
			if (sid==null||"".equals(sid)) {
				//默认最大编号
				sid="S0000001";
			}else{
				String temp = sid.substring(1);
				int i = Integer.parseInt(temp);
				i++;
				temp = String.valueOf(i);
				int length = temp.length();
				for(int j=0;j<7-length;j++){
					temp="0"+temp;
				}
				sid = "S"+temp;
				tx.commit();
				return sid;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return null;
		}finally {
			if (tx!=null) {
				tx = null;
			}
		}
		return null;
	}

}
