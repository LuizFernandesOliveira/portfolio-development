package portfoliodevelopment.infrastructure.person.database.postgresql;

import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import portfoliodevelopment.domain.person.entity.Person;
import portfoliodevelopment.domain.person.repository.PersonRepository;
import portfoliodevelopment.infrastructure.person.database.PersonJpaRepository;

@RequiredArgsConstructor
public class PersonPostgresqlRepository implements PersonRepository {
  private final PersonJpaRepository repository;

  @Override
  public void create(Person person) {
    var model =
        PersonModel.builder()
            .id(person.getId())
            .name(person.getName())
            .email(person.getEmail())
            .phone(person.getPhone())
            .birthDate(person.getBirthDate())
            .gender(person.getGender())
            .build();

    repository.save(model);
  }

  @Override
  public void update(Person person) {
    var model =
        PersonModel.builder()
            .id(person.getId())
            .name(person.getName())
            .email(person.getEmail())
            .phone(person.getPhone())
            .birthDate(person.getBirthDate())
            .gender(person.getGender())
            .photoUrl(person.getPhotoUrl())
            .build();

    repository.save(model);
  }

  @Override
  public Person find(UUID id) {
    var person =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Person not found with id: " + id));

    return Person.builder()
        .id(person.getId())
        .name(person.getName())
        .email(person.getEmail())
        .phone(person.getPhone())
        .gender(person.getGender())
        .birthDate(person.getBirthDate())
        .photoUrl(person.getPhotoUrl())
        .build();
  }
}
