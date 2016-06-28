
package com.wentjiang.action;

import java.util.List;

import com.wentjiang.entity.Students;
import com.wentjiang.service.StudentsDAO;
import com.wentjiang.service.impl.StudentsDAOImpl;

/*
@author  jiangwentao 
@E-mail  wentjiang@sina.com
@date    2016年6月27日 下午10:28:56 
*/
public class StudentsAction extends SuperAction{

	private static final long serialVersionUID = 1L;
	
	private Students students;
	
	//查询所有学生动作
	public String query(){
		StudentsDAO sDao = new StudentsDAOImpl();
		List<Students> list = sDao.queryAllStudents();
		if (list!=null&&list.size()>0) {
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
	
	//删除学生动作
	public String delete(){
		StudentsDAO sdao= new StudentsDAOImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	
	public String add(){
		StudentsDAO sdao= new StudentsDAOImpl();
		if (students.getSid()==null||"".equals(students.getSid())) {
			sdao.addStudents(students);	
			return "add_success";
		}else{
			sdao.updateStudents(students);
			return "update_success";
		}
		
		
	
	}

	public String modify(){
//		StudentsDAO sdao= new StudentsDAOImpl();
//		sdao.updateStudents(students);
//		return "modify_success";
		//获得修改的学生
		String sid = request.getParameter("sid");
		StudentsDAO sdao= new StudentsDAOImpl();
		Students s = sdao.queryStudentsBySid(sid);
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	
	public Students getStudents() {
		return students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}
	
	
	
	
}
