package com.cdac.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cdac.models.Response;
import com.cdac.pojos.User;
import com.cdac.services.UserService;

@RestController
@CrossOrigin
public class LoginController {
	@Autowired  
	private UserService userService;   
	
	
	
	  @PostMapping("/users/authenticateUser")
		public ResponseEntity<?> authenticateUser(@RequestBody User user,HttpSession session) {

			User authuser = userService.authenticate(user.getEmail(), user.getPassword());

			
			
			  if(authuser!=null && authuser.getRole().equals("admin") ){
			  return Response.success(authuser); }
			  
			  else if(authuser!=null &&
			  authuser.getRole().equals("trainer") ){
			 
			  return Response.success(authuser);  }
			  
			  else if(authuser!=null &&
			  authuser.getRole().equals("member") ){
			  
			  return Response.success(authuser); } 
			 
			return Response.error("401");
		}
	
}

