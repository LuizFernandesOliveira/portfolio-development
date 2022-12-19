package portfoliodevelopment.domain.person.usecase.finding;

import lombok.RequiredArgsConstructor;
import portfoliodevelopment.domain.__shared.usecase.UseCase;
import portfoliodevelopment.domain.person.repository.PersonRepository;
import portfoliodevelopment.domain.person.usecase.finding.dto.FindInput;
import portfoliodevelopment.domain.person.usecase.finding.dto.FindMapper;
import portfoliodevelopment.domain.person.usecase.finding.dto.FindOutput;

@RequiredArgsConstructor
public class PersonFind implements UseCase<FindInput, FindOutput> {
  private final PersonRepository personRepository;

  @Override
  public FindOutput execute(FindInput input) {
    var person = personRepository.find(input.id());
    return FindMapper.toOutput(person);
  }
}
