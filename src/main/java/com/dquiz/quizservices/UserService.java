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
		User u = userRepo.save(user);
		if(u.getEmail().equals(user.getEmail()))
			System.out.println("registered successfully");
		else
			System.out.println("registration unsuccessfull");
		
	}

	public User validateUser(String email, String password) {
	    
	    User user = userRepo.findByEmail(email);
	    
	    if (user != null) {
	        if (password.equals(user.getPassword())) {
	            return user;
	        } else {
	            return new User();
	        }
	    } else {
	        return new User();
	    }
	}
	
	public String getUsernameById(int id)
	{
		return userRepo.findById(id).orElse(new User()).getUsername();
	}


}
