package com.xiyu.service;

import java.util.List;

import com.xiyu.bean.Student;
import com.xiyu.util.Page;

public interface PageService {
	//��ҳ��ѯ
	List<Student> selectAllStuByPage(Page page);
	
	//��ȡ��������
	int stuCount();
}
