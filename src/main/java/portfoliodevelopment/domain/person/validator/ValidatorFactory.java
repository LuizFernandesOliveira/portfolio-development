package portfoliodevelopment.domain.person.validator;

import portfoliodevelopment.domain.__shared.validator.Validator;
import portfoliodevelopment.domain.person.entity.Person;

public class ValidatorFactory {

  public static Validator<Person> createValidatorFields() {
    return new FieldsValidator();
  }
}
