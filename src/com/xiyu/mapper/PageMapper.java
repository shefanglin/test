package com.xiyu.mapper;

import java.util.List;

import com.xiyu.bean.Student;
import com.xiyu.util.Page;


public interface PageMapper {
	//��ҳ��ѯ
	List<Student> selectAllByPage(Page page);
	
	//��ѯ����
	int getCount();
}
