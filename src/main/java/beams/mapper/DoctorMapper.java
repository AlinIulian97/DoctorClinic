package beams.mapper;

import beams.entity.Doctor;
import beams.model.doctor.DoctorRequest;
import beams.model.doctor.DoctorResponse;
import org.mapstruct.Mapper;

@Mapper
public interface DoctorMapper {

    Doctor map(DoctorRequest doctorRequest);

    DoctorResponse map(Doctor doctor);
}
