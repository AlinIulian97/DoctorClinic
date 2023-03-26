package beams.model.medicalReport;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicalReportResponse {

    private LocalDate consultDate;
    private String disease;
    private String treatment;
    private Integer restDays;
    private LocalDate returnToMedic;
    private Long doctorId;
    private Long consultId;
}
