package beams.model.consult;

import beams.entity.Doctor;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsultResponse {

    private LocalDate consultDate;
    private Doctor doctor;
    private String issueDetails;
    private Long doctorId;
}
