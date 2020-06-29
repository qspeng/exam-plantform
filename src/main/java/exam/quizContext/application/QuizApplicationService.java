package exam.quizContext.application;

import exam.quizContext.application.command.CreateOrUpdateQuizCommand;
import exam.quizContext.domain.model.blankQuiz.Quiz;
import exam.quizContext.domain.model.blankQuiz.QuizId;
import exam.quizContext.domain.model.blankQuiz.QuizRepository;
import exam.quizContext.domain.service.BlankQuizDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizApplicationService {
    private QuizRepository quizRepository;

    public QuizApplicationService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<BlankQuizDto> getAllBlankQuiz() {
        return quizRepository.getAll().stream().map(BlankQuizDto::fromBlankQuiz).collect(Collectors.toList());
    }

    public BlankQuizDto create(CreateOrUpdateQuizCommand createOrUpdateQuizCommand) {
        final QuizId quizId = quizRepository.nextQuizId();

        Quiz quiz = Quiz.of(quizId, createOrUpdateQuizCommand.getQuestion(), createOrUpdateQuizCommand.getAnswer(), createOrUpdateQuizCommand.getScore());
        quizRepository.save(quiz);
        return BlankQuizDto.fromBlankQuiz(quiz);
    }

    public BlankQuizDto update(String id, CreateOrUpdateQuizCommand createOrUpdateQuizCommand) {
        final QuizId quizId = QuizId.of(id);
        Quiz quiz = Quiz.of(quizId, createOrUpdateQuizCommand.getQuestion(), createOrUpdateQuizCommand.getAnswer(), createOrUpdateQuizCommand.getScore());
        quizRepository.save(quiz);
        return BlankQuizDto.fromBlankQuiz(quiz);
    }



    public BlankQuizDto delete(String id) {
        final QuizId quizId = QuizId.of(id);
        return BlankQuizDto.fromBlankQuiz(quizRepository.delete(quizId));
    }

    public BlankQuizDto get(String id) {
        final QuizId quizId = QuizId.of(id);
        return BlankQuizDto.fromBlankQuiz(quizRepository.find(quizId));
    }
}
