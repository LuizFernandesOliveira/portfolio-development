package portfoliodevelopment.infrastructure.person.database;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import portfoliodevelopment.infrastructure.person.database.postgresql.PersonModel;

public interface PersonJpaRepository extends JpaRepository<PersonModel, UUID> {}
