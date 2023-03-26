package beams.controller;

import beams.model.medicalReport.MedicalReportRequest;
import beams.model.medicalReport.MedicalReportResponse;
import beams.service.MedicalReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class MedicalReportController {
    private final MedicalReportService medicalReportService;

    @PostMapping("/create")
    public MedicalReportResponse saveMedicalReport(@RequestBody MedicalReportRequest medicalReportRequest){
        return medicalReportService.saveMedicalReport(medicalReportRequest);
    }
}
