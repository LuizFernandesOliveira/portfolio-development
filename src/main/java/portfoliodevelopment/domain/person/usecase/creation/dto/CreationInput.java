package portfoliodevelopment.domain.person.usecase.creation.dto;

import java.time.LocalDate;
import lombok.Builder;
import portfoliodevelopment.domain.person.entity.Gender;

@Builder
public record CreationInput(
    String name, String email, String phone, LocalDate birthDate, Gender gender) {}
