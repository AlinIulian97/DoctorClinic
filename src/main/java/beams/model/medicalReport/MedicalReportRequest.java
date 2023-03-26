package beams.model.medicalReport;

import beams.entity.Consult;
import beams.entity.Doctor;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalReportRequest {

    private LocalDate consultDate;
    private String disease;
    private String treatment;
    private Integer restDays;
    private LocalDate returnToMedic;
    private Long doctorId;
    private Long consultId;

}
