package com.bit2017.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2017.jblog.dto.JSONResult;
import com.bit2017.jblog.service.UserService;
import com.bit2017.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("/checkid")
	public JSONResult checkEmail(@RequestParam(value = "id", required = true, defaultValue = "") String id) {
		boolean isExists = userService.exists(id);
		return JSONResult.success(isExists ? "exist" : "not exist");
	}

	@RequestMapping("/joinform")
	public String joinform() {
		return "/user/join";
	}

	@RequestMapping("/join")
	public String join(@ModelAttribute @Valid UserVo userVo, BindingResult result, Model model) {
		if (result.hasErrors() == true) {
			model.addAllAttributes(result.getModel());
			return "/user/joinform";
		}
		userService.joinUser(userVo);
		return "redirect:/user/joinsuccess";
	}

	@RequestMapping("/loginform")
	public String loginform() {
		return "/user/login";
	}

	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "user/joinsuccess";
	}
}
