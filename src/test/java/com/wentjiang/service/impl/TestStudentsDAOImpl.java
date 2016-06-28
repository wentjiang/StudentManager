
package com.wentjiang.service.impl;
/*
@author  jiangwentao 
@E-mail  wentjiang@sina.com
@date    2016年6月27日 下午10:25:01 
*/

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.wentjiang.entity.Students;
import com.wentjiang.service.StudentsDAO;

public class TestStudentsDAOImpl {

	@Test
	public void testQueryAllStudents(){
		StudentsDAO sdao= new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		for(Students students : list){
			System.out.println(students.toString());
		}
	}
//	@Test
//	public void testGetNewSid(){
//		StudentsDAOImpl sdao= new StudentsDAOImpl();
//		String sid = sdao.getNewSid();
//		System.out.println(sid);
//	}
	
	@Test
	public void testSaveStudents(){
		StudentsDAO sdao= new StudentsDAOImpl();
		Students students = new Students(null, "wentjiang", "man", 	new Date(), "江南小区");
		sdao.addStudents(students);
	}
}
