package portfoliodevelopment.domain.__shared.usecase;

public interface UseCase<T, R> {
  R execute(T input);
}
