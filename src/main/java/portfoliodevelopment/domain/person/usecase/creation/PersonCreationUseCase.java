package portfoliodevelopment.domain.person.usecase.creation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portfoliodevelopment.domain.__shared.usecase.UseCase;
import portfoliodevelopment.domain.person.repository.PersonRepository;
import portfoliodevelopment.domain.person.usecase.creation.dto.CreationInput;
import portfoliodevelopment.domain.person.usecase.creation.dto.CreationMapper;
import portfoliodevelopment.domain.person.usecase.creation.dto.CreationOutput;

@Service
@RequiredArgsConstructor
public class PersonCreationUseCase implements UseCase<CreationInput, CreationOutput> {
  private final PersonRepository personRepository;

  @Override
  public CreationOutput execute(CreationInput input) {
    var mapped = CreationMapper.toEntity(input);

    personRepository.create(mapped);

    return CreationMapper.toOutput(mapped);
  }
}
