package com.test.me.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by jingbo.lin on 2016/8/4.
 */
@Service
public class UserNameConfirm{

	@Autowired
	private UserDao userDao;

	public boolean confirm(User user){
		if(userDao.getName(user.getId()).equals(user.getName())){
			return true;
		}

		return false;

	}
}
