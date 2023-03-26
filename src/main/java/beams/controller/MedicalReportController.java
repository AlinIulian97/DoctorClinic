package beams.controller;

import beams.model.medicalReport.MedicalReportRequest;
import beams.model.medicalReport.MedicalReportResponse;
import beams.model.medicalReport.MedicalReportUpdateTreatment;
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

    @GetMapping("{id}")
    public MedicalReportResponse findMedicalReport(@PathVariable Long id){
        return medicalReportService.findMedicalReport(id);
    }

    @PatchMapping("/update/{id}")
    public void updateMedicalReport(@PathVariable Long id, @RequestBody MedicalReportUpdateTreatment medicalReportUpdateTreatment){
       medicalReportService.updateMedicalReport(id, medicalReportUpdateTreatment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicalReport(@PathVariable Long id){
        medicalReportService.deleteMedicalReport(id);
    }
}
