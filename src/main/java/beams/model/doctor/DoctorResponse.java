package beams.model.doctor;

import beams.entity.Enums.SpecializationEnum;
import lombok.Data;

@Data
public class DoctorResponse {

    private String firstName;
    private String lastName;
    private SpecializationEnum specialization;
    private byte experience;
    private String description;
    private String university;
}
