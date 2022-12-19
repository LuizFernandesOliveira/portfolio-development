package portfoliodevelopment.domain.person.repository;

import java.util.UUID;
import portfoliodevelopment.domain.person.entity.Person;

public interface PersonRepository {
  void create(Person person);

  void update(Person person);

  Person find(UUID id);
}
