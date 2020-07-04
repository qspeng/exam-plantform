package exam.quizContext.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
public class CreateOrUpdateBlankQuizCommand {
    @NotNull
    private String question;
    @NotNull
    private String answer;
    @PositiveOrZero
    private int score;
}