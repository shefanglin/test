package com.xiyu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiyu.bean.Student;
import com.xiyu.mapper.PageMapper;
import com.xiyu.util.Page;

@Service
public class PageServiceImpl implements PageService{

	@Resource
	private PageMapper PageMapper;
	
	//获取分页信息
	@Override
	public List<Student> selectAllStuByPage(Page page) {
		List<Student> list = PageMapper.selectAllByPage(page);
		return list;
	}

	//获取数据总数
	@Override
	public int stuCount( ) {
		return PageMapper.getCount();
		
	}
	
}
