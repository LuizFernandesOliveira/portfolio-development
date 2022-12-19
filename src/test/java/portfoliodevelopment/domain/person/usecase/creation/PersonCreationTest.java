package portfoliodevelopment.domain.person.usecase.creation;

import static org.assertj.core.api.BDDAssertions.assertThat;
import static org.mockito.BDDMockito.then;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import portfoliodevelopment.domain.person.entity.Gender;
import portfoliodevelopment.domain.person.entity.Person;
import portfoliodevelopment.domain.person.repository.PersonRepository;
import portfoliodevelopment.domain.person.usecase.creation.dto.CreationInput;
import portfoliodevelopment.domain.person.usecase.creation.dto.CreationMapper;

@ExtendWith(MockitoExtension.class)
class PersonCreationTest {
  @Mock private PersonRepository personRepository;
  @Captor private ArgumentCaptor<Person> personCaptor;
  @InjectMocks private PersonCreation useCase;

  @Test
  void executeOk() {
    var input =
        CreationInput.builder()
            .name("Name test")
            .email("email@email.com")
            .phone("123456789")
            .birthDate(LocalDate.of(2000, 1, 1))
            .gender(Gender.MALE)
            .build();

    var output = useCase.execute(input);

    then(personRepository).should().create(personCaptor.capture());
    var personCreated = CreationMapper.toOutput(personCaptor.getValue());

    assertThat(output).usingRecursiveComparison().isEqualTo(personCreated);
  }
}
