package exam.quizContext.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Data
@AllArgsConstructor
public class CreateOrUpdateQuizCommand {
    @NotNull
    private String question;
    @NotNull
    private String answer;
    @PositiveOrZero
    private int score;
}