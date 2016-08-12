package com.test.me.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jingbo.lin on 2016/7/25.
 */

@Controller

public class MainController {

	@Autowired
	UserConfirm userConfirm;

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/")
	public String display(HttpSession session){
		if (session.getAttribute("name") != null){
			return "redirect:/index";
		}

		return "test";
	}

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(User user,HttpSession session){

		System.out.println(user.toString());
		Map<String,Object> map = new HashMap<String,Object>();

//		UserConfirm userConfirm = new UserConfirm();

		boolean t = userConfirm.confirm(user);

		if(t){
			System.out.println("Success");
			map.put("msg","Success");
			session.setAttribute("id",user.getId());
			session.setAttribute("name",user.getName());
			session.setAttribute("password",user.getPassword());

		}
		else{
			System.out.println("fail");
			map.put("msg","fail");

		}
		return map;
	}

	@RequestMapping("/signUp")
	@Cacheable("signUP")
	public String signUP(){
		return "signUp";
	}


	@RequestMapping(value = "/insert",method = RequestMethod.GET)
	public String insert(@RequestParam String name,@RequestParam String pwd,HttpSession session){
		if (session.getAttribute("name") != null){
			return "index";
		}
		Map<String,Object> map = new HashMap<>();
		User user = userDao.insert(name,pwd);
		session.setAttribute("id",user.getId());
		session.setAttribute("name",user.getName());
		session.setAttribute("password",user.getPassword());
		map.put("name",user.getName());
		map.put("id",user.getId());
		return "index";
	}

	@RequestMapping("/index")
	public String loginSuccess(){
	return "index";
	}

	@RequestMapping("/edit")
	public String editUser(){
		return "editUser";
	}

	@RequestMapping("/get")
	public String getItem(HttpServletRequest request,HttpSession session){
	//	Map<String,Object> map = new HashMap<String,Object>();
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s + " == " + session.getAttribute(s));
		}

		return "redirect:/edit";

	}



	/*
	@RequestMapping(value = "/login")
	@ResponseBody
	public  void login(User user, HttpServletRequest request,
					   HttpServletResponse response) throws IOException {

		System.out.println("come");
		System.out.println(user.getName());

	//	String x = name.substring(0,name.length()-1);
	//	System.out.println(x);
		String result = null;
		Map<String,Object> map = new HashMap<String,Object>();
		PrintWriter out = null;
		response.setContentType("application/json");
		if(user.getName().equals("123")){
			System.out.println("Success");
			map.put("msg","Success");
			result = "{\"msg\":\"" + "success" + "\"}";
		}
		else{
			System.out.println("fail");
			map.put("msg","fail");
			result = "{\"msg\":\"" + "fail" + "\"}";
		}

		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return map;
	}

*/
}
