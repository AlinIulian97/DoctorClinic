package beams.model.consult;

import beams.entity.Doctor;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConsultRequest {

    private LocalDate consultDate;
    private Doctor doctor;
    private String issueDetails;
    private Long doctorId;
    private Long reportId;

}
