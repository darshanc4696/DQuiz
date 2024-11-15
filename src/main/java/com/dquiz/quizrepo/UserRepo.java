package com.dquiz.quizrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dquiz.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	User findByEmail(String email);

}
