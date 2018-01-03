package com.xiyu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiyu.bean.Student;
import com.xiyu.service.StudentService;
import com.xiyu.service.PageService;
import com.xiyu.util.Page;

@Controller
public class StudentController {
	
	@Resource
	private StudentService StudentService;
	
	@Resource
	private PageService PageService;

	//����ѧ����Ϣ
	@RequestMapping("addStu")
	public String addStudent(Student stu){
		if(StudentService.addStudent(stu))
			return "redirect:/selAll.action";
		return "error";
	}
	
	//ɾ��ѧ����Ϣ
	@ResponseBody
	@RequestMapping("delStu")
	public String delStudent(int id){
		if(StudentService.deleteStudent(id)){
			return "true";
		}
		return "false";
	}
	
	//����ѧ����Ϣ
	@RequestMapping("selAll")
	public String selAllStudent(Model model,Page page){
		//List<Student> list = StudentService.selectAllStudent();
		int stuCount = PageService.stuCount();
		page.setTotalCount(stuCount);
		List<Student> list = PageService.selectAllStuByPage(page);
		model.addAttribute("list", list);
		model.addAttribute("page",page);
		return "show";
	}
	
	//�޸�ѧ����Ϣ
	@RequestMapping("updateStu")
	public String updateStudent(Student stu){
		try {
			if(StudentService.updateStudent(stu));
			return "redirect:/selAll.action";
		} catch (Exception e) {
			return "error";
		}
	}
	
	//������������ѧ����Ϣ
	@RequestMapping("selStuByName")
	public String selStuByName(Model model,@RequestParam String name){
		List<Student> list = StudentService.selectName(name);
		model.addAttribute("list",list);
		return "show";
	}
	
	//����ɾ��ѧ����Ϣ
	@RequestMapping("delMany")
	public String delMany(@RequestParam String ids){
		String[] idss = ids.split(",");
		for(String id:idss){
			int idChange = Integer.parseInt(id);
			if(!StudentService.deleteStudent(idChange)){
				return "error";
			}
		}
		return "redirect:/selAll.action";
	}

}
