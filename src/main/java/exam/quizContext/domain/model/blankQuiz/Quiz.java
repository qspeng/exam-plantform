package exam.quizContext.domain.model.blankQuiz;

import exam.paperContext.domain.shared.Entity;
import jdk.internal.joptsimple.internal.Strings;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(of = {"quizId"})
public class Quiz implements Entity<Quiz> {
    private QuizId quizId;
    private String question;
    private String answer;
    private int score;
    private LocalDateTime createTime;

    private Quiz(QuizId quizId, String qeestion, String answer, int score) {
        this.quizId = quizId;
        this.question = qeestion;
        this.answer = answer;
        this.score = score;
        createTime = LocalDateTime.now();
    }

    public static Quiz of(QuizId quizId, String question, String answer, int score) {
        assert !Strings.isNullOrEmpty(question);
        assert !Strings.isNullOrEmpty(answer);
        assert quizId != null;
        assert score >= 0;

        return new Quiz(quizId, question, answer, score);
    }

    public static Quiz of(String question, String answer, int score) {
        assert !Strings.isNullOrEmpty(question);
        assert !Strings.isNullOrEmpty(answer);
        assert score >= 0;

        return new Quiz(null, question, answer, score);
    }

    public QuizId getQuizId() {
        return quizId;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean sameIdentityAs(Quiz other) {
        return quizId.sameValueAs(other.getQuizId());
    }
}
