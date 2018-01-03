package com.xiyu.service;

import java.util.List;

import com.xiyu.bean.Student;
import com.xiyu.util.Page;

public interface PageService {
	//分页查询
	List<Student> selectAllStuByPage(Page page);
	
	//获取数据总数
	int stuCount();
}
