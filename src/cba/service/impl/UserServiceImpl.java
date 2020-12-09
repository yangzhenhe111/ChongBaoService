package cba.service.impl;

import com.google.gson.Gson;

import cba.dao.impl.UserDaoImpl;
import cba.entity.User;

public class UserServiceImpl {
	private UserServiceImpl() {

	}

	private static UserServiceImpl impl = new UserServiceImpl();

	public static UserServiceImpl getInstance() {
		return impl;
	}
	public boolean isUser(String num,String pwd) {
		 return UserDaoImpl.getInstance().isUser(num, pwd);
	}
	public String getUser(String phone) {
		UserDaoImpl impl = UserDaoImpl.getInstance();
		User user = impl.getUser(phone);
		return new Gson().toJson(user);
	}
}
