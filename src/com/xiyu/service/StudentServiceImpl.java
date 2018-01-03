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

	//���ѧ��
	public boolean addStudent(Student stu) {
		int insert = StudentMapper.insert(stu);
		if(insert > 0)
			return true;
		return false;
	}

	//ɾ��ѧ��
	public boolean deleteStudent(int id) {
		int primaryKey = StudentMapper.deleteByPrimaryKey(id);
		if(primaryKey > 0)
			return true;
		return false;
	}

	//�޸�ѧ��
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

	//����ѧ����������ѧ��
	public List<Student> selectName(String name) {
		List<Student> list = StudentMapper.selectByStudentName(name);
		return list;
	}

	//��������ѧ����Ϣ
	public List<Student> selectAllStudent() {
		List<Student> allStudent = StudentMapper.selectAllStudent();
		return allStudent;
	}
}
