package com.dquiz.quizrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dquiz.models.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer>{

	@Query("select q from Quiz q where q.title = :category")
	Quiz findByTitle(String category);

}
