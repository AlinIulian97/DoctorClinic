package beams.model.doctor;


import beams.entity.Enums.SpecializationEnum;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DoctorRequest {

    private String firstName;
    private String lastName;
    private SpecializationEnum specialization;
    private byte experience;
    private String description;
    private String university;

}
