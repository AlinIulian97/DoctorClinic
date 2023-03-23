package beams.service;

import beams.entity.Doctor;
import beams.exception.BusinessException;
import beams.mapper.DoctorMapper;
import beams.model.DoctorRequest;
import beams.model.DoctorResponse;
import beams.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import javax.transaction.Transactional;
import java.sql.SQLException;

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

    public void deleteDoctor(Integer id){
        doctorRepository.delete
                (doctorRepository.findById(id).orElseThrow(()
                        -> new BusinessException("This doctor is not found")));
    }
}
