package portfoliodevelopment.domain.person.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import portfoliodevelopment.domain.__shared.usecase.UseCase;
import portfoliodevelopment.domain.person.usecase.creation.dto.CreationInput;
import portfoliodevelopment.domain.person.usecase.creation.dto.CreationOutput;
import portfoliodevelopment.domain.person.usecase.finding.dto.FindInput;
import portfoliodevelopment.domain.person.usecase.finding.dto.FindOutput;

@Component
@RequiredArgsConstructor
public class PersonFacadeImpl implements PersonFacade {
  private final UseCase<CreationInput, CreationOutput> creationUseCase;
  private final UseCase<FindInput, FindOutput> findUseCase;

  @Override
  public CreationOutput create(CreationInput input) {
    return creationUseCase.execute(input);
  }

  @Override
  public FindOutput find(FindInput input) {
    return findUseCase.execute(input);
  }
}
