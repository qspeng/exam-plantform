package exam.quizContext.domain.shared;

public interface ValueObject<T> {
    boolean sameValueAs(T other);
}
