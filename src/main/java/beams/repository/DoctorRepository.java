package beams.repository;

import beams.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "doctor", path = "doctors")
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
