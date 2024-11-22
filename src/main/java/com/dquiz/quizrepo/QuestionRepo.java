package com.dquiz.quizrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dquiz.models.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{

	@Query("select q from Question q where q.quizid = :quizid")
	List<Question> findByQuizId(int quizid);

}
