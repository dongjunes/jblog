package com.bit2017.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2017.jblog.service.CategoryService;
import com.bit2017.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/{id}")
	public String category(Model model) {
		List<CategoryVo> list = categoryService.getMessage();
		model.addAttribute("list", list);
		return "blog/blog-admin-category";
	}

	@RequestMapping("/{id}/add")
	public String add(@ModelAttribute CategoryVo vo, Model model) {
		categoryService.add(vo);
		return "redirect:/blog/{id}";
	}
	
	@RequestMapping("/{id}/remove")
	public String remove(@RequestParam("no") Long no){
		categoryService.remove(no);
		return "redirect:/blog/{id}";
	}
	

}
