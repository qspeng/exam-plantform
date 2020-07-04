package exam.quizContext.domain.model.blankQuiz;

import exam.paperContext.domain.shared.Entity;
import jdk.internal.joptsimple.internal.Strings;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(of = {"blankQuizId"})
public class BlankQuiz implements Entity<BlankQuiz> {
    private BlankQuizId blankQuizId;
    private String question;
    private String answer;
    private int score;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private BlankQuiz(BlankQuizId blankQuizId, String qeestion, String answer, int score) {
        this.blankQuizId = blankQuizId;
        this.question = qeestion;
        this.answer = answer;
        this.score = score;
        createTime = LocalDateTime.now();
    }

    public static BlankQuiz of(BlankQuizId blankQuizId, String question, String answer, int score) {
        assert !Strings.isNullOrEmpty(question);
        assert !Strings.isNullOrEmpty(answer);
        assert blankQuizId != null;
        assert score >= 0;

        return new BlankQuiz(blankQuizId, question, answer, score);
    }

    public static BlankQuiz revise(BlankQuizId blankQuizId, String question, String answer, int score) {
        BlankQuiz updated = of(blankQuizId, question, answer, score);
        updated.updateTheUpdateTime(LocalDateTime.now());
        return updated;
    }

    public void updateTheUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public static BlankQuiz of(String question, String answer, int score) {
        assert !Strings.isNullOrEmpty(question);
        assert !Strings.isNullOrEmpty(answer);
        assert score >= 0;

        return new BlankQuiz(null, question, answer, score);
    }

    public BlankQuizId getBlankQuizId() {
        return blankQuizId;
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
    public boolean sameIdentityAs(BlankQuiz other) {
        return blankQuizId.sameValueAs(other.getBlankQuizId());
    }
}
