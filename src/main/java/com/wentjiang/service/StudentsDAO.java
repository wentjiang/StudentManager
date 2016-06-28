
package com.wentjiang.service;
/*
@author  jiangwentao 
@E-mail  wentjiang@sina.com
@date    2016年6月27日 下午8:12:03 
*/

import java.util.List;

import com.wentjiang.entity.Students;

public interface StudentsDAO {
	
	//查询所有学生资料
	public List<Students> queryAllStudents();
	//根据学生编号查询学生资料
	public Students queryStudentsBySid(String sid);
	//添加学生资料
	public boolean addStudents(Students s);
	//修改学生资料
	public boolean updateStudents(Students s);
	//删除学生
	public boolean deleteStudents(String sid);
}
