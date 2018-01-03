package com.xiyu.mapper;

import java.util.List;

import com.xiyu.bean.Student;
import com.xiyu.util.Page;


public interface PageMapper {
	//分页查询
	List<Student> selectAllByPage(Page page);
	
	//查询总数
	int getCount();
}
