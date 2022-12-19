package portfoliodevelopment.domain.person.usecase.finding.dto;

import portfoliodevelopment.domain.person.entity.Person;

public class FindMapper {
  public static FindOutput toOutput(Person person) {
    return FindOutput.builder()
        .id(person.getId())
        .name(person.getName())
        .email(person.getEmail())
        .phone(person.getPhone())
        .birthDate(person.getBirthDate())
        .gender(person.getGender())
        .photoUrl(person.getPhotoUrl())
        .build();
  }
}
