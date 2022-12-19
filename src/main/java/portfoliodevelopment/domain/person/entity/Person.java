package portfoliodevelopment.domain.person.entity;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import portfoliodevelopment.domain.person.validator.ValidatorFactory;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

  private UUID id;
  private String name;
  private String email;
  private String phone;
  private LocalDate birthDate;
  private Gender gender;
  private String photoUrl;

  public Person validate() {
    ValidatorFactory.createValidatorFields().validate(this);
    return this;
  }
}
