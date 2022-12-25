package portfoliodevelopment.domain.person.usecase.creation.dto;

import java.util.UUID;
import portfoliodevelopment.domain.person.entity.Person;

public class CreationMapper {

  public static Person toEntity(CreationInput input) {
    return Person.builder()
        .id(UUID.randomUUID())
        .name(input.name())
        .email(input.email())
        .phone(input.phone())
        .birthDate(input.birthDate())
        .gender(input.gender())
        .build().validate();
  }

  public static CreationOutput toOutput(Person person) {
    return CreationOutput.builder()
        .id(person.getId())
        .name(person.getName())
        .email(person.getEmail())
        .phone(person.getPhone())
        .birthDate(person.getBirthDate())
        .build();
  }
}
