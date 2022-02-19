package com.foodapp.maven.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodapp.maven.dao.UserDaoImpl;


@Service("UserService")
public class UserServiceImpl implements UserService
{
	@Autowired
	UserDaoImpl userdao;
	

	@Override
	public boolean Send(String UserName, String password,String phone) {
		boolean flag;
		flag = userdao.Authenticate(UserName, password,phone);
		
		return flag;
		
		// TODO Aukdjhdmnx vcreate yegh vate andy thdto-generated method stub
		
	}
	/*
	 * private static final Logger LOGGER =
	 * LogManager.getLogger(TestController.class);
	 * 
	 * @RequestMapping(value = "/te", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public UserServiceImpl() { // TODO Auto-generated constructor
	 * stub } public Send(String Uname,String Uname) {
	 * 
	 * }
	 */
}
