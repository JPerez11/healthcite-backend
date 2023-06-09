package co.gov.heqc.healthcite.repositories;

import co.gov.heqc.healthcite.entities.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<PeopleEntity, Long> {

    Optional<PeopleEntity> findByEmail(String email);
    Optional<PeopleEntity> findByDocumentAndRoleName(String docuement, String role);
    List<PeopleEntity> findAllByRoleName(String name);
    boolean existsByDocument(String document);
    boolean existsByEmail(String email);

}
