package portfoliodevelopment.domain.person.validator;

import java.time.LocalDate;
import java.util.Objects;
import portfoliodevelopment.domain.__shared.validator.Validator;
import portfoliodevelopment.domain.person.entity.Gender;
import portfoliodevelopment.domain.person.entity.Person;

public class FieldsValidator implements Validator<Person> {
  private static final String EMPTY = "";

  @Override
  public void validate(Person entity) {
    this.validateId(entity.getId());
    this.validateName(entity.getName());
    this.validateEmail(entity.getEmail());
    this.validateBirthDate(entity.getBirthDate());
    this.validateGender(entity.getGender());
  }

  private void validateName(String name) {
    var message = "Name is invalid";
    var isNull = Objects.isNull(name);
    var isEmpty = EMPTY.equals(name);
    this.valid(message, isNull, isEmpty);
  }

  private void validateEmail(String email) {
    var message = "Email is invalid";
    var isNull = Objects.isNull(email);
    var isEmpty = EMPTY.equals(email);
    this.valid(message, isNull, isEmpty);
  }

  private void validateBirthDate(LocalDate birthDate) {
    var message = "BirthDate is invalid";
    var isNull = Objects.isNull(birthDate);
    this.valid(message, isNull);
  }

  private void validateGender(Gender gender) {
    var message = "Gender is invalid";
    var isNull = Objects.isNull(gender);
    this.valid(message, isNull);
  }
}
