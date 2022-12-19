package portfoliodevelopment.infrastructure.person.database.postgresql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import portfoliodevelopment.domain.person.entity.Gender;
import portfoliodevelopment.domain.person.entity.Person;
import portfoliodevelopment.infrastructure.person.database.PersonJpaRepository;

@ExtendWith(MockitoExtension.class)
class PersonPostgresqlRepositoryTest {
  @Mock private PersonJpaRepository personJpaRepository;
  @Captor ArgumentCaptor<PersonModel> personModelCaptor;
  @InjectMocks private PersonPostgresqlRepository repository;

  @Test
  void create() {
    var person =
        Person.builder()
            .id(UUID.randomUUID())
            .name("Name test")
            .email("email@email.com")
            .phone("123123123")
            .birthDate(LocalDate.of(2021, 1, 1))
            .gender(Gender.MALE)
            .build();

    repository.create(person);

    then(personJpaRepository).should().save(personModelCaptor.capture());

    var modelSaved = personModelCaptor.getValue();

    assertThat(modelSaved).usingRecursiveComparison().isEqualTo(person);
  }

  @Test
  void update() {
    var person =
        Person.builder()
            .id(UUID.randomUUID())
            .name("Name test")
            .email("email@email.com")
            .phone("123123123")
            .birthDate(LocalDate.of(2021, 1, 1))
            .gender(Gender.MALE)
            .photoUrl("http://photo.com")
            .build();

    repository.update(person);

    then(personJpaRepository).should().save(personModelCaptor.capture());

    var modelSaved = personModelCaptor.getValue();

    assertThat(modelSaved).usingRecursiveComparison().isEqualTo(person);
  }

  @Test
  void find() {
    var model =
        PersonModel.builder()
            .id(UUID.randomUUID())
            .name("Name test")
            .email("email@email.com")
            .phone("123123123")
            .birthDate(LocalDate.of(2021, 1, 1))
            .gender(Gender.MALE)
            .photoUrl("http://photo.com")
            .build();

    given(personJpaRepository.findById(model.getId())).willReturn(Optional.of(model));

    var person = repository.find(model.getId());

    assertThat(person).usingRecursiveComparison().isEqualTo(model);
  }

  @Test
  void notFind() {
    var id = UUID.randomUUID();
    given(personJpaRepository.findById(id)).willReturn(Optional.empty());

    assertThatThrownBy(() -> repository.find(id))
        .isInstanceOf(EntityNotFoundException.class)
        .hasMessage("Person not found with id: %s", id);
  }
}
