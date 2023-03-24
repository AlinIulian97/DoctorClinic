package beams.service;

import beams.entity.Doctor;
import beams.exception.BusinessException;
import beams.mapper.DoctorMapper;
import beams.model.doctor.DoctorRequest;
import beams.model.doctor.DoctorResponse;
import beams.model.doctor.DoctorUpdate;
import beams.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;


    public DoctorResponse createDoctor(DoctorRequest doctorRequest) {
        Doctor doctorToSave = doctorMapper.map(doctorRequest);
        doctorRepository.save(doctorToSave);
        return doctorMapper.map(doctorToSave);
    }

    public void deleteDoctor(Long id){
        doctorRepository.delete
                (doctorRepository.findById(id).orElseThrow(()
                        -> new BusinessException("This doctor is not found")));
    }

    public void updateDoctor(Long id, DoctorUpdate doctorUpdate){
        Doctor doctorToUpdate = doctorRepository
                .findById(id)
                .orElseThrow(
                () -> new BusinessException("Doctor is not found"));

        doctorToUpdate.setExperience(doctorUpdate.getExperience());
        doctorToUpdate.setDescription(doctorUpdate.getDescription());
        doctorRepository.save(doctorToUpdate);
    }

   public DoctorResponse findDoctor(Long id){
    return doctorMapper.map(doctorRepository
            .findById(id)
            .orElseThrow(
                    ()-> new BusinessException("Doctor is not found")));
   }

}
