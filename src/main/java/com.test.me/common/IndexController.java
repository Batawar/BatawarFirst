package com.test.me.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jingbo.lin on 2016/8/2.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private UserDao userDao;

	@Autowired
	UserPasswordConfirm userPasswordConfirm;


	public ModelAndView getItem(Model model, HttpSession session){
		//Map<String,Object> map = new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView();
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s + " == " + session.getAttribute(s));
			modelAndView.addObject(s,session.getAttribute(s));

		}

		modelAndView.setViewName("editUser");
		return modelAndView;
	}

	@RequestMapping("/edit")
	public String changeItemInfo(User user,HttpSession session){


		userDao.changeName(user.getId(),user.getName());
		userDao.changePassword(user.getId(),user.getPassword());

			//info.setNum(Integer.parseInt(user.getPassword()));
		session.setAttribute("name",user.getName());
		session.setAttribute("password",user.getPassword());
		System.out.println(session.getAttribute("name"));



		return "redirect:/edit";
	}

	@RequestMapping("/logOut")
	public String logOut(HttpSession session){
		session.invalidate();

		return "redirect:/";
	}

	@RequestMapping("/test")
	@Cacheable("calculateResult")
	public String calculateResult() {
		//loger.debug("Performing expensive calculation...");
		// perform computationally expensive calculation
		return "result";
	}
//	public void mytest(HttpSession session){
//
//		String name = (String) session.getAttribute("name");
//		String password = (String) session.getAttribute("password");
//		User user = findByName(name,password);
//
//	}

//	@Caching(
//			cacheable = {
//				@Cacheable(value = "user",key = "#user.name")
//				@Cacheable(value = "user",key = "#user.password")
//			}
//	)

//	public User findByName(String name, String password){
//		User user = new User();
//		user.setId(Integer.parseInt(userDao.getId(name,password)));
//		user.setName(name);
//		user.setPassword(password);
//		System.out.println("666");
//		return user;
//	}

}
