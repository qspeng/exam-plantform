package exam.quizContext.domain.shared;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
