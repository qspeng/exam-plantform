package exam.quizContext.domain.service;

import exam.quizContext.domain.model.blankQuiz.Quiz;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDto {
    private String quizId;
    private int score;
    private String question;
    private String answer;

    public static Quiz toBlankQuiz(BlankQuizDto blankQuizDto) {
        return Quiz.of(blankQuizDto.getQuestion(), blankQuizDto.getAnswer(), blankQuizDto.getScore());
    }

    public static BlankQuizDto fromBlankQuiz(Quiz quiz) {
        return new BlankQuizDto(quiz.getQuizId().getId(), quiz.getScore(), quiz.getQuestion(), quiz.getAnswer());
    }
}
