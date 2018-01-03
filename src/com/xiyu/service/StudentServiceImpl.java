package com.xiyu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiyu.bean.Student;
import com.xiyu.mapper.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Resource
	private StudentMapper StudentMapper;

	//添加学生
	public boolean addStudent(Student stu) {
		int insert = StudentMapper.insert(stu);
		if(insert > 0)
			return true;
		return false;
	}

	//删除学生
	public boolean deleteStudent(int id) {
		int primaryKey = StudentMapper.deleteByPrimaryKey(id);
		if(primaryKey > 0)
			return true;
		return false;
	}

	//修改学生
	public boolean updateStudent(Student stu) throws Exception {
		int primaryKey; 
		try{
			primaryKey = StudentMapper.updateByPrimaryKey(stu);
		}catch(Exception e){
			throw new Exception(e);
		}
		if(primaryKey > 0)
			return true;
		return false;
	}

	//根据学生姓名查找学生
	public List<Student> selectName(String name) {
		List<Student> list = StudentMapper.selectByStudentName(name);
		return list;
	}

	//查找所有学生信息
	public List<Student> selectAllStudent() {
		List<Student> allStudent = StudentMapper.selectAllStudent();
		return allStudent;
	}
}
