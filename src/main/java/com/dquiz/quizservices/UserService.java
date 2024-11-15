package com.dquiz.quizservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dquiz.models.User;
import com.dquiz.quizrepo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(7);
	
	public void saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user) ;
		
	}

	public String validateUser(String email, String password) {
	    
	    User user = userRepo.findByEmail(email);
	    
	    if (user != null) {
	        if (encoder.matches(password, user.getPassword())) {
	            return "loggedin";
	        } else {
	            return "password wrong";
	        }
	    } else {
	        return "user not exist";
	    }
	}


}
