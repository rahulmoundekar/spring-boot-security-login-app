package com.boot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.boot.app.service.IUserInfoService;

@Controller
@RequestMapping("app")
public class UserInfoController {
	@Autowired
	private IUserInfoService userInfoService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("errorMsg", "Your username and password are invalid.");
		}
		if (logout != null) {
			model.addAttribute("logout", "You have been logged out successfully.");
		}
		return "login";
	}

	@RequestMapping(value = "/secure/article-details", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getAllUserArticles() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userArticles", userInfoService.getAllUserArticles());
		mav.setViewName("articles");
		return mav;
	}

	@RequestMapping(value = "/error", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView error() {
		ModelAndView mav = new ModelAndView();
		String errorMessage = "You are not authorized for the requested data.";
		mav.addObject("errorMsg", errorMessage);
		mav.setViewName("403");
		return mav;
	}

}