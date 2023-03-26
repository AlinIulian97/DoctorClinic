package beams.mapper;

import beams.entity.MedicalReport;
import beams.model.medicalReport.MedicalReportRequest;
import beams.model.medicalReport.MedicalReportResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MedicalReportMapper {

    MedicalReport map(MedicalReportRequest medicalReportRequest);

    @Mapping(target = "doctorId", source = "doctor.id")
    @Mapping(target = "consultId", source = "consult.id")
    MedicalReportResponse map(MedicalReport medicalReport);
}
