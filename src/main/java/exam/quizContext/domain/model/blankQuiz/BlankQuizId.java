package exam.quizContext.domain.model.blankQuiz;

import exam.paperContext.domain.shared.ValueObject;
import jdk.internal.joptsimple.internal.Strings;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class BlankQuizId implements ValueObject<BlankQuizId> {
    private String id;

    public static BlankQuizId of(String id) {
        assert !Strings.isNullOrEmpty(id);
        return new BlankQuizId(id);
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlankQuizId blankQuizId = (BlankQuizId) o;
        return Objects.equals(getId(), blankQuizId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public boolean sameValueAs(BlankQuizId other) {
        return equals(other);
    }
}
