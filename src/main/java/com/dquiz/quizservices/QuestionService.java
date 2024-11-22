package com.dquiz.quizservices;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dquiz.models.Question;
import com.dquiz.quizrepo.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;

	public List<Question> getQuestions(int quizid) {
		return questionRepo.findByQuizId(quizid);
	}

	public int calculateScore(Map<String, String> userAnswer) {
		int score = 0;

        for (Map.Entry<String, String> entry : userAnswer.entrySet()) {
            // Extract the question ID from the key (e.g., "question_1")
            String questionKey = entry.getKey();
            String selectedAnswer = entry.getValue();
            int questionId = Integer.parseInt(questionKey.split("_")[1]);

            // Fetch the question from the database
            Question question = questionRepo.findById(questionId).orElse(null);

            if (question != null && question.getCorrectAnswer().equals(selectedAnswer)) {
                score++;
            }
        }

        return score;
	}

}
