package com.javarush.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javarush.model.User;
import com.javarush.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map, HttpServletRequest request) {
		User user = new User();
		map.put("user", user);
		map.put("userList", userService.getAllUsers());
		
		PagedListHolder<User> pagedListHolder = new PagedListHolder(userService.getAllUsers());
		pagedListHolder.setPageSize(10);
		map.put("users", pagedListHolder.getPageList());
		
		String page = request.getParameter("page");
		if ("prev".equals(page))
		{
			pagedListHolder.previousPage();			
		}
		if ("next".equals(page))
		{
			pagedListHolder.nextPage();
		}
		map.put("users", pagedListHolder.getPageList());

		return "user";
	}
	@RequestMapping(value="/user.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute User user, BindingResult result,
			@RequestParam String action, Map<String, Object> map) {
		User resultUser = new User();
		switch (action.toLowerCase()) {
		case "add":
			userService.add(user);
			resultUser = user;
			break;
		case "edit":
			userService.edit(user);
			resultUser = user;
			break;
		case "delete":
			userService.delete(user.getId());
			break;
		case "search":
			User searchedUser = userService.getUser(user.getId());
			resultUser = searchedUser != null ? searchedUser : new User();
			break;
		}
		map.put("user", resultUser);
		map.put("userList", userService.getAllUsers());
		
		PagedListHolder<User> pagedListHolder = new PagedListHolder(userService.getAllUsers());
		pagedListHolder.setPageSize(10);
		map.put("users", pagedListHolder.getPageList());
		return "user";
	}
	
}
