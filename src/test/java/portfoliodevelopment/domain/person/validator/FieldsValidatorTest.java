package portfoliodevelopment.domain.person.validator;

import static org.assertj.core.api.BDDAssertions.assertThatThrownBy;

import java.time.LocalDate;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import portfoliodevelopment.domain.person.entity.Gender;
import portfoliodevelopment.domain.person.entity.Person;

class FieldsValidatorTest {

  @Test
  void shouldValidateOk() {
    Person.builder()
        .id(UUID.randomUUID())
        .name("Test")
        .email("test@test.com")
        .birthDate(LocalDate.of(2022, 1, 1))
        .gender(Gender.MALE)
        .build()
        .validate();
  }

  @Test
  void shouldValidateThrowWhenFieldsInvalid() {
    assertThatThrownBy(() -> Person.builder().build().validate())
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Id is invalid");

    assertThatThrownBy(() -> Person.builder().id(UUID.randomUUID()).build().validate())
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Name is invalid");

    assertThatThrownBy(() -> Person.builder().id(UUID.randomUUID()).name("").build().validate())
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Name is invalid");

    Assertions.assertThatThrownBy(
            () -> Person.builder().id(UUID.randomUUID()).name("Test").build().validate())
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Email is invalid");

    assertThatThrownBy(
            () -> Person.builder().id(UUID.randomUUID()).name("Test").email("").build().validate())
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Email is invalid");

    assertThatThrownBy(
            () ->
                Person.builder()
                    .id(UUID.randomUUID())
                    .name("Test")
                    .email("test@test.com")
                    .build()
                    .validate())
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BirthDate is invalid");

    assertThatThrownBy(
            () ->
                Person.builder()
                    .id(UUID.randomUUID())
                    .name("Test")
                    .email("test@test.com")
                    .birthDate(null)
                    .build()
                    .validate())
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BirthDate is invalid");

    assertThatThrownBy(
            () ->
                Person.builder()
                    .id(UUID.randomUUID())
                    .name("Test")
                    .email("test@test.com")
                    .birthDate(LocalDate.of(2022, 1, 1))
                    .build()
                    .validate())
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Gender is invalid");
  }
}
