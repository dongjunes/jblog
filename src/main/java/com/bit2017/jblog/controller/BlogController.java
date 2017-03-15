package com.bit2017.jblog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2017.jblog.service.BlogService;
import com.bit2017.jblog.service.CategoryService;
import com.bit2017.jblog.vo.BlogVo;
import com.bit2017.jblog.vo.CategoryVo;
import com.bit2017.jblog.vo.WriteVo;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/{id}")
	public String blogMain(@PathVariable String id, Model model,
			@RequestParam(value = "category_no", required = true, defaultValue = "1") Long categoryNo,
			@RequestParam(value = "no", required = true, defaultValue = "") Long no,
			HttpSession session) {
		BlogVo vo = blogService.get(id);
		session.setAttribute("title", vo.getTitle());
		model.addAttribute("vo", vo);
		List<CategoryVo> list = categoryService.getMessage();
		model.addAttribute("list", list);
		List<WriteVo> writeList = blogService.getList(categoryNo);
		model.addAttribute("writeList", writeList);
		WriteVo viewVo = null;
		if (no == null) {
			viewVo = blogService.getVo(categoryNo);
		} else {
			viewVo = blogService.getVo(categoryNo, no);
		}
		model.addAttribute("viewVo", viewVo);
		return "blog/blog-main";
	}

	@RequestMapping("{id}/admin/basic")
	public String adminBasic(@PathVariable String id, Model model) {
		BlogVo vo = blogService.get(id);
		model.addAttribute("vo", vo);
		return "blog/blog-admin-basic";
	}

	@RequestMapping("{id}/admin/basic/insert")
	public String insert(@RequestParam("id") String id, @RequestParam("title") String title,
			@RequestParam("logo") MultipartFile logo) {
		blogService.upload(id, title, logo);
		return "redirect:/blog/{id}";
	}

}
