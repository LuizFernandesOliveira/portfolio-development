package portfoliodevelopment.domain.person.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
  MALE("Masculino"),
  FEMALE("Feminino");

  private final String description;
}
