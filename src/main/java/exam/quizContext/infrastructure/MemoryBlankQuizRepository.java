package exam.quizContext.infrastructure;

import exam.quizContext.domain.model.blankQuiz.BlankQuiz;
import exam.quizContext.domain.model.blankQuiz.BlankQuizId;
import exam.quizContext.domain.model.blankQuiz.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private final Set<BlankQuiz> blankQuizs = new HashSet<>();

    @Override
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return blankQuizs.stream()
                .filter(quiz -> quiz.getBlankQuizId().equals(blankQuizId))
                .findFirst()
                .orElseThrow(() -> new QuizNotFoundException("Quiz not found!"));
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizs.stream()
                .filter(existQuiz -> existQuiz.equals(blankQuiz))
                .findFirst().map(existQuiz -> blankQuizs.remove(existQuiz));
        blankQuizs.add(blankQuiz);
    }

    @Override
    public BlankQuizId nextQuizId() {
        return new BlankQuizId("quiz-" + UUID.randomUUID().toString());
    }

    @Override
    public List<BlankQuiz> getAll() {
        return new ArrayList<>(blankQuizs);
    }

    @Override
    public BlankQuiz delete(BlankQuizId blankQuizId) {
        final BlankQuiz blankQuiz = this.find(blankQuizId);
        blankQuizs.remove(blankQuiz);
        return blankQuiz;
    }
}
