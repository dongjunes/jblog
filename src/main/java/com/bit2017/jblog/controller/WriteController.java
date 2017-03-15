package com.bit2017.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2017.jblog.service.CategoryService;
import com.bit2017.jblog.service.WriteService;
import com.bit2017.jblog.vo.CategoryVo;
import com.bit2017.jblog.vo.WriteVo;

@Controller
@RequestMapping("/write")
public class WriteController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private WriteService writeService;

	@RequestMapping("/{id}")
	public String writeMain(Model model) {
		List<CategoryVo> list = categoryService.getMessage();
		model.addAttribute("list", list);
		return "blog/blog-admin-write";
	}

	@RequestMapping("/{id}/add")
	public String add(@ModelAttribute WriteVo vo) {
		System.out.println("controller : " + vo);
		writeService.add(vo);
		return "redirect:/blog/{id}";
	}

}
