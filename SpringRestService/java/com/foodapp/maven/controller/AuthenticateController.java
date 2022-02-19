package com.foodapp.maven.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodapp.maven.impl.UserServiceImpl;
import com.foodapp.maven.model.request.AuthenticateUserRequest;
import com.foodapp.maven.model.response.AuthenticateUserResponse;



@Controller
@RequestMapping("/auth")
public class AuthenticateController {
	
	 private static final Logger LOGGER = LogManager.getLogger(AuthenticateController.class);
	 @Autowired
	 UserServiceImpl usr;
		
	 
		/*
		 * @RequestMapping(value = "/te1" , method = RequestMethod.POST)
		 * 
		 * @ResponseBody public String test1(){ return "{\"te\":\"shubham\"}";
		 * 
		 * }
		 */
	 @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	 @ResponseBody
	 public AuthenticateUserResponse authenticate(@RequestBody AuthenticateUserRequest request) {
		      boolean flag;
		 AuthenticateUserResponse userResponse = new AuthenticateUserResponse();
		 flag = usr.Send(request.getUsername(), request.getPassword(),request.getPhone());
		 if(flag) {
			 userResponse.setStatus("ok");
		 }else {
			 userResponse.setStatus("UnAuthenticate User");
		 }
		 return userResponse;
			 
	 }
}
