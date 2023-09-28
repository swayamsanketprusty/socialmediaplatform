package com.example.registermvc;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlineplatform.model.User;
import com.example.onlineplatform.model.UserRepo;


@RestController
public class RegistrationController {
@Autowired
private UserRepo userRepo;

@RequestMapping("/check")
public String registercheck() {
	return ("check registered");
}
@RequestMapping("/register-user/{userName}/{password}")
public String registerUser(@PathVariable("userName") String userName,
		@PathVariable("password") String password) {
	User u=new User();
	u.setId(5);
	u.setName(userName);
	u.setPassword(password);
	userRepo.save(u);
	return("successfully registered");
}

}
