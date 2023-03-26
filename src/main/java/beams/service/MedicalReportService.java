package beams.service;

import beams.entity.MedicalReport;
import beams.exception.BusinessException;
import beams.mapper.MedicalReportMapper;
import beams.model.medicalReport.MedicalReportRequest;
import beams.model.medicalReport.MedicalReportResponse;
import beams.model.medicalReport.MedicalReportUpdateTreatment;
import beams.repository.ConsultRepository;
import beams.repository.DoctorRepository;
import beams.repository.MedicalReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MedicalReportService {

    private final MedicalReportMapper medicalReportMapper;
    private final MedicalReportRepository medicalReportRepository;
    private final DoctorRepository doctorRepository;
    private final ConsultRepository consultRepository;

    public MedicalReportResponse saveMedicalReport(MedicalReportRequest medicalReportRequest) {
        MedicalReport medicalReport = medicalReportMapper.map(medicalReportRequest);
        medicalReport.setDoctor(doctorRepository
                .findById(medicalReportRequest.getDoctorId())
                .orElseThrow(
                        () -> new BusinessException("Doctor is not found")));
        medicalReport.setConsult(consultRepository
                .findById(medicalReportRequest.getConsultId())
                .orElseThrow(
                        () -> new BusinessException("Consult is not found")));
        medicalReportRepository.save(medicalReport);
        return medicalReportMapper.map(medicalReport);
    }

    public void deleteMedicalReport(Long id) {
        MedicalReport medicalReport = medicalReportRepository
                .findById(id).orElseThrow(
                        () -> new BusinessException("Report is not found"));
        medicalReportRepository.delete(medicalReport);
    }


    public void updateMedicalReport(Long id, MedicalReportUpdateTreatment medicalReportUpdateTreatment) {
        MedicalReport medicalReportUpdate = medicalReportRepository.findById(id)
                .orElseThrow(
                        () -> new BusinessException("Report is not found"));
        medicalReportUpdate.setTreatment(medicalReportUpdateTreatment.getTreatment());
        medicalReportRepository.save(medicalReportUpdate);
    }


        public MedicalReportResponse findMedicalReport(Long id){
         return medicalReportMapper
                 .map(medicalReportRepository
                         .findById(id)
                         .orElseThrow(
                                 ()-> new BusinessException("Report is not found")));
        }
    }

