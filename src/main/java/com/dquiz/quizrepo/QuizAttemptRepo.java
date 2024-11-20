package com.dquiz.quizrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dquiz.models.QuizAttempt;

@Repository
public interface QuizAttemptRepo extends JpaRepository<QuizAttempt, Integer> {

	@Query("Select qa from QuizAttempt qa where qa.user.userid = :userid order by qa.attemptDate desc")
	List<QuizAttempt> findByUserId(int userid);

//    @Query("SELECT qa FROM QuizAttempt qa WHERE qa.quiz.quizId = :quizId ORDER BY qa.score DESC")
//    List<QuizAttempt> findTopScoresByQuizId(@Param("quizId") Long quizId);
}

