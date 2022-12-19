package portfoliodevelopment.domain.__shared.validator;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public interface Validator<T> {

  void validate(T entity);

  default void validateId(UUID id) {
    var message = "Id is invalid";
    var isNull = Objects.isNull(id);
    this.valid(message, isNull);
  }

  default void valid(String message, Boolean... validations) {
    if (Arrays.asList(validations).contains(Boolean.TRUE)) {
      throw new IllegalArgumentException(message);
    }
  }
}
