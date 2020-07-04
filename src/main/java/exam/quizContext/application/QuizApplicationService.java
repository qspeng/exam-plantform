package exam.quizContext.application;

import exam.quizContext.application.command.CreateOrUpdateBlankQuizCommand;
import exam.quizContext.domain.model.blankQuiz.BlankQuiz;
import exam.quizContext.domain.model.blankQuiz.BlankQuizId;
import exam.quizContext.domain.model.blankQuiz.BlankQuizRepository;
import exam.quizContext.domain.service.BlankQuizDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizApplicationService {
    private BlankQuizRepository blankQuizRepository;

    public QuizApplicationService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public List<BlankQuizDto> getAllBlankQuiz() {
        return blankQuizRepository.getAll().stream().map(BlankQuizDto::fromBlankQuiz).collect(Collectors.toList());
    }

    public BlankQuizDto create(CreateOrUpdateBlankQuizCommand createOrUpdateBlankQuizCommand) {
        final BlankQuizId blankQuizId = blankQuizRepository.nextQuizId();

        BlankQuiz blankQuiz = BlankQuiz.of(blankQuizId, createOrUpdateBlankQuizCommand.getQuestion(), createOrUpdateBlankQuizCommand.getAnswer(), createOrUpdateBlankQuizCommand.getScore());
        blankQuizRepository.save(blankQuiz);
        return BlankQuizDto.fromBlankQuiz(blankQuiz);
    }

    public BlankQuizDto update(String id, CreateOrUpdateBlankQuizCommand createOrUpdateBlankQuizCommand) {
        final BlankQuizId blankQuizId = BlankQuizId.of(id);
        BlankQuiz blankQuiz = BlankQuiz.revise(blankQuizId, createOrUpdateBlankQuizCommand.getQuestion(), createOrUpdateBlankQuizCommand.getAnswer(), createOrUpdateBlankQuizCommand.getScore());
        blankQuizRepository.save(blankQuiz);
        return BlankQuizDto.fromBlankQuiz(blankQuiz);
    }


    public BlankQuizDto delete(String id) {
        final BlankQuizId blankQuizId = BlankQuizId.of(id);
        return BlankQuizDto.fromBlankQuiz(blankQuizRepository.delete(blankQuizId));
    }

    public BlankQuizDto get(String id) {
        final BlankQuizId blankQuizId = BlankQuizId.of(id);
        return BlankQuizDto.fromBlankQuiz(blankQuizRepository.find(blankQuizId));
    }
}
