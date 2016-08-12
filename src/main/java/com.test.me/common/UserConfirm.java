package com.test.me.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by jingbo.lin on 2016/8/1.
 */
@Service
public class UserConfirm {

//	private UserNameConfirm userNameConfirm = new UserNameConfirm();
	@Autowired
	UserNameConfirm userNameConfirm;
	@Autowired
	UserPasswordConfirm userPasswordConfirm;
	//private UserPasswordConfirm userPasswordConfirm = new UserPasswordConfirm();
	@Cacheable(value = "user",key = "#user.id")

	public boolean confirm(User user){
		if(userNameConfirm.confirm(user) && userPasswordConfirm.confirm(user)){
			return true;
		}


		return false;

	}

	/*
	public boolean confirm(User user) {
		UserInfo[] allUser = UserInfo.values();
		for(UserInfo userInfo : allUser){
			System.out.println(userInfo.getName()+userInfo.getNum());
			if(userInfo.getName().equals(user.getName())){

				if(userInfo.getNum() == Integer.parseInt(user.getPassword())){

					return true;
				}
			}
			else {
				return false;
			}
		}
		return false;
	}
	*/
}
