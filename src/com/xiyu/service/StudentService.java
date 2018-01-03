package com.xiyu.service;

import java.util.List;

import com.xiyu.bean.Student;

public interface StudentService {
	//���ѧ��
	public boolean addStudent(Student stu);
	//ɾ��ѧ��
	public boolean deleteStudent(int id);
	//�޸�ѧ��
	public boolean updateStudent(Student stu) throws Exception;
	//����ѧ����������ѧ��
	public List<Student> selectName(String name);
	//��������ѧ����Ϣ
	public List<Student> selectAllStudent();
}
