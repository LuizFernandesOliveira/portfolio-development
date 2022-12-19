package portfoliodevelopment.domain.person.usecase.creation.dto;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;
import portfoliodevelopment.domain.person.entity.Gender;

@Builder
public record CreationOutput(
    UUID id, String name, String email, String phone, LocalDate birthDate, Gender gender) {}
