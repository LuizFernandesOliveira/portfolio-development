package portfoliodevelopment.domain.person.usecase.finding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.time.LocalDate;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import portfoliodevelopment.domain.person.entity.Gender;
import portfoliodevelopment.domain.person.entity.Person;
import portfoliodevelopment.domain.person.repository.PersonRepository;
import portfoliodevelopment.domain.person.usecase.finding.dto.FindInput;
import portfoliodevelopment.domain.person.usecase.finding.dto.FindMapper;

@ExtendWith(MockitoExtension.class)
class PersonFindTest {
  @Mock private PersonRepository personRepository;
  @InjectMocks private PersonFind useCase;

  @Test
  void executeOk() {
    var input = FindInput.builder().id(UUID.randomUUID()).build();

    var person =
        Person.builder()
            .id(input.id())
            .name("Name test")
            .email("email@email.com")
            .birthDate(LocalDate.of(2000, 1, 1))
            .phone("123123123")
            .gender(Gender.MALE)
            .build();

    given(personRepository.find(input.id())).willReturn(person);

    var output = useCase.execute(input);

    assertThat(output).usingRecursiveComparison().isEqualTo(FindMapper.toOutput(person));
  }
}
