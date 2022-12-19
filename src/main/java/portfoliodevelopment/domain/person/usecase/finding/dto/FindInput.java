package portfoliodevelopment.domain.person.usecase.finding.dto;

import java.util.UUID;
import lombok.Builder;

@Builder
public record FindInput(UUID id) {}
