package portfoliodevelopment.infrastructure.person.database.postgresql;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import portfoliodevelopment.domain.person.entity.Gender;
import portfoliodevelopment.infrastructure.__shared.database.UUIDGenerator;

@Entity
@Table(name = "persons")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class PersonModel {
  @Id
  @GeneratedValue(generator = UUIDGenerator.NAME)
  @GenericGenerator(name = UUIDGenerator.NAME, strategy = UUIDGenerator.STRATEGY)
  private UUID id;
  private String name;
  private String email;
  private String phone;
  private LocalDate birthDate;

  @Enumerated(EnumType.STRING)
  private Gender gender;
  private String photoUrl;
}
