package beams.mapper;

import beams.entity.Doctor;
import beams.model.DoctorRequest;
import beams.model.DoctorResponse;
import org.mapstruct.Mapper;

@Mapper
public interface DoctorMapper {

    Doctor map(DoctorRequest doctorRequest);

    DoctorResponse map(Doctor doctor);
}
