package exam.quizContext.infrastructure;

import exam.quizContext.domain.model.blankQuiz.Quiz;
import exam.quizContext.domain.model.blankQuiz.QuizId;
import exam.quizContext.domain.model.blankQuiz.QuizRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MemoryQuizRepository implements QuizRepository {
    private Set<Quiz> quizzes = new HashSet<>();

    @Override
    public Quiz find(QuizId quizId) {
        return quizzes.stream()
                .filter(quiz -> quiz.getQuizId().equals(quizId))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(Quiz quiz) {
        quizzes.add(quiz);
    }

    @Override
    public QuizId nextQuizId() {
        return new QuizId("quiz-" + UUID.randomUUID().toString());
    }

    @Override
    public List<Quiz> getAll() {
        return quizzes.stream().collect(Collectors.toList());
    }

    @Override
    public Quiz delete(QuizId quizId) {
        final Quiz quiz = this.find(quizId);
        quizzes.remove(quiz);
        return quiz;
    }
}
