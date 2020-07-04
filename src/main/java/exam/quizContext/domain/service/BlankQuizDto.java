package exam.quizContext.domain.service;

import exam.quizContext.domain.model.blankQuiz.BlankQuiz;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDto {
    private String quizId;
    private int score;
    private String question;
    private String answer;

    public static BlankQuiz toBlankQuiz(BlankQuizDto blankQuizDto) {
        return BlankQuiz.of(blankQuizDto.getQuestion(), blankQuizDto.getAnswer(), blankQuizDto.getScore());
    }

    public static BlankQuizDto fromBlankQuiz(BlankQuiz blankQuiz) {
        return new BlankQuizDto(blankQuiz.getBlankQuizId().getId(), blankQuiz.getScore(), blankQuiz.getQuestion(), blankQuiz.getAnswer());
    }
}
