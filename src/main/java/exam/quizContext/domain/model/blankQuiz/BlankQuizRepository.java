package exam.quizContext.domain.model.blankQuiz;

import java.util.List;

public interface BlankQuizRepository {
    BlankQuiz find(BlankQuizId blankQuizId);

    void save(BlankQuiz blankQuiz);

    BlankQuizId nextQuizId();

    List<BlankQuiz> getAll();

    BlankQuiz delete(BlankQuizId blankQuizId);
}
