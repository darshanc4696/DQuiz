package com.dquiz.quizrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dquiz.models.QuizAttempt;

@Repository
public interface QuizAttemptRepo extends JpaRepository<QuizAttempt, Integer> {

//    @Query("SELECT qa FROM QuizAttempt qa WHERE qa.quiz.quizId = :quizId ORDER BY qa.score DESC")
//    List<QuizAttempt> findTopScoresByQuizId(@Param("quizId") Long quizId);
}

