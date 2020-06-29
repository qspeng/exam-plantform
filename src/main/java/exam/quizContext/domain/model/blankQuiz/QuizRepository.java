package exam.quizContext.domain.model.blankQuiz;

import java.util.List;

public interface QuizRepository {
    Quiz find(QuizId quizId);

    void save(Quiz quiz);

    QuizId nextQuizId();

    List<Quiz> getAll();

    Quiz delete(QuizId quizId);
}
