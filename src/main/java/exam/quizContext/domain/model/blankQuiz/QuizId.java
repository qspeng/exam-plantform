package exam.quizContext.domain.model.blankQuiz;

import exam.paperContext.domain.shared.ValueObject;
import jdk.internal.joptsimple.internal.Strings;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class QuizId implements ValueObject<QuizId> {
    private String id;

    public static QuizId of(String id) {
        assert !Strings.isNullOrEmpty(id);
        return new QuizId(id);
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizId quizId = (QuizId) o;
        return Objects.equals(getId(), quizId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public boolean sameValueAs(QuizId other) {
        return equals(other);
    }
}
