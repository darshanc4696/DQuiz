package com.dquiz.quizrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dquiz.models.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{

}
