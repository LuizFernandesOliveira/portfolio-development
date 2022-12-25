package portfoliodevelopment.domain.person.facade;
import portfoliodevelopment.domain.person.usecase.creation.dto.CreationInput;
import portfoliodevelopment.domain.person.usecase.creation.dto.CreationOutput;
import portfoliodevelopment.domain.person.usecase.finding.dto.FindInput;
import portfoliodevelopment.domain.person.usecase.finding.dto.FindOutput;

public interface PersonFacade {
  CreationOutput create(CreationInput input);
  FindOutput find(FindInput input);
}
