package com.dquiz.quizservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dquiz.models.User;
import com.dquiz.quizrepo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public void saveUser(User user) {
		userRepo.save(user) ;
		
	}

	public String validateUser(String email, String password) {
	    
	    User user = userRepo.findByEmail(email);
	    
	    if (user != null) {
	        if (password.equals(user.getPassword())) {
	            return "loggedin";
	        } else {
	            return "password wrong";
	        }
	    } else {
	        return "user not exist";
	    }
	}


}
