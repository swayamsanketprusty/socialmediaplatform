package com.example.onlineplatform;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.onlineplatform.model.UserRepo;

@Controller
public class LoginController {
	@Autowired
	private UserRepo userRepo;
	RestTemplate restTemplate = new RestTemplate();
@RequestMapping("/")
public String checkMVC() {
	return "login";
}
@RequestMapping("/login")
public String loginHomePage(@RequestParam ("userName") String userName,
		@RequestParam("password") String password, Model model) {
	User u = null;
	try {
		u=(User) userRepo.findByName(userName);
	}
	catch(Exception e) {
		System.out.println("User not found !!!");
	}
	if(u!=null) {
		model.addAttribute("Userame",userName);
		return "homePage";
	}
	model.addAttribute("error", "User Not found,kindly register");
	return "login";
}
@RequestMapping("/register")
public String goToRegistrationPage() {
	return "register";
	
}
@RequestMapping("/set-user")
public String goToRegisterMicroservice(@RequestParam ("userName") String userName,
		@RequestParam("password1") String password1,
		@RequestParam("password2") String password2,Model model
		) {
	if(password1.equals(password2)) {
		restTemplate.getForObject("http://localhost:8791/register-user/{"+userName+"}/{"+password1,
				String.class);
		model.addAttribute("registerSuccess","successfully registered,kindly login to continue");
		
	}else {
		model.addAttribute("registrationError","password not same");
		
	}
	return "login";
	
}
}
