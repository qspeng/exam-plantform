package exam.quizContext.userInterface;

import exam.quizContext.application.QuizApplicationService;
import exam.quizContext.application.command.CreateOrUpdateQuizCommand;
import exam.quizContext.domain.service.BlankQuizDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blank-quizzes")
public class QuizController {
    private QuizApplicationService quizApplicationService;

    public QuizController(QuizApplicationService quizApplicationService) {
        this.quizApplicationService = quizApplicationService;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    BlankQuizDto create(@RequestBody CreateOrUpdateQuizCommand command) {
        return quizApplicationService.create(command);
    }

    @GetMapping
    List<BlankQuizDto> getAll() {
        return quizApplicationService.getAllBlankQuiz();
    }

    @PutMapping("/{quizId}")
    @ResponseStatus(HttpStatus.OK)
    BlankQuizDto update(@PathVariable("quizId") String quizId, @RequestBody CreateOrUpdateQuizCommand command) {
        return quizApplicationService.update(quizId, command);
    }

    @DeleteMapping("/{quizId}")
    @ResponseStatus(HttpStatus.OK)
    BlankQuizDto delete(@PathVariable("quizId") String quizId) {
        return quizApplicationService.delete(quizId);
    }

    @GetMapping("/{quizId}")
    @ResponseStatus(HttpStatus.OK)
    BlankQuizDto get(@PathVariable("quizId") String quizId) {
        return quizApplicationService.get(quizId);
    }

}
