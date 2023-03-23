package beams.model;


import beams.entity.Enums.SpecializationEnum;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DoctorRequest {

    private String firstName;
    private String lastName;
    private SpecializationEnum specialization;
    private byte experience;
    private String description;
    private String university;

}
