package com.xiyu.service;

import java.util.List;

import com.xiyu.bean.Student;

public interface StudentService {
	//添加学生
	public boolean addStudent(Student stu);
	//删除学生
	public boolean deleteStudent(int id);
	//修改学生
	public boolean updateStudent(Student stu) throws Exception;
	//根据学生姓名查找学生
	public List<Student> selectName(String name);
	//查找所有学生信息
	public List<Student> selectAllStudent();
}
