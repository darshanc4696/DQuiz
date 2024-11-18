package com.dquiz.quizrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dquiz.models.Options;

@Repository
public interface OptionRepo extends JpaRepository<Options, Integer> {
	
	

}
