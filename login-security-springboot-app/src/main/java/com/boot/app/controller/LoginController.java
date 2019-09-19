package com.boot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.GrantedAuthority;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String viewLogin() {
		return "redirect:app/login";
	}

	@RequestMapping(value = "app/loginPass", method = RequestMethod.GET)
	public String loginPass(Model map, HttpServletRequest request, HttpServletResponse response) {
		String url = "";
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();

		List<String> roles = new ArrayList<String>();

		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}

		if (isSystemAdmin(roles)) {
			System.out.println("admin controller");
			url = "redirect:secure/article-details";
		} else if (isUser(roles)) {
			System.out.println("user controller");
			url = "redirect:secure/article-details";
		} else {
			System.out.println("default login url");
			url = "redirect:/";
		}

		return url;
	}

	private boolean isSystemAdmin(List<String> roles) {
		if (roles.contains("ROLE_ADMIN")) {
			return true;
		}
		return false;
	}

	private boolean isUser(List<String> roles) {
		if (roles.contains("ROLE_USER")) {
			return true;
		}
		return false;
	}
}
