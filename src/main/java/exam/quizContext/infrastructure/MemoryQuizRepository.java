package exam.quizContext.infrastructure;

import exam.quizContext.domain.model.blankQuiz.Quiz;
import exam.quizContext.domain.model.blankQuiz.QuizId;
import exam.quizContext.domain.model.blankQuiz.QuizRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemoryQuizRepository implements QuizRepository {
    private final Set<Quiz> quizzes = new HashSet<>();

    @Override
    public Quiz find(QuizId quizId) {
        return quizzes.stream()
                .filter(quiz -> quiz.getQuizId().equals(quizId))
                .findFirst()
                .orElseThrow(() -> new QuizNotFoundException("Quiz not found!"));
    }

    @Override
    public void save(Quiz quiz) {
        quizzes.stream()
                .filter(existQuiz -> existQuiz.equals(quiz))
                .findFirst().map(existQuiz -> quizzes.remove(existQuiz));
        quizzes.add(quiz);
    }

    @Override
    public QuizId nextQuizId() {
        return new QuizId("quiz-" + UUID.randomUUID().toString());
    }

    @Override
    public List<Quiz> getAll() {
        return new ArrayList<>(quizzes);
    }

    @Override
    public Quiz delete(QuizId quizId) {
        final Quiz quiz = this.find(quizId);
        quizzes.remove(quiz);
        return quiz;
    }
}
