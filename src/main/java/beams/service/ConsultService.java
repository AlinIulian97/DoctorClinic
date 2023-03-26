package beams.service;

import beams.entity.Consult;
import beams.exception.BusinessException;
import beams.mapper.ConsultMapper;
import beams.model.consult.ConsultRequest;
import beams.model.consult.ConsultResponse;
import beams.model.consult.ConsultUpdateDate;
import beams.repository.ConsultRepository;
import beams.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ConsultService {

    private final ConsultRepository consultRepository;
    private final ConsultMapper consultMapper;
    private final DoctorRepository doctorRepository;

    public ConsultResponse createConsult(ConsultRequest consultRequest) {
        Consult consultToCreate = consultMapper.map(consultRequest);
        consultToCreate.setDoctor(doctorRepository.findById(consultRequest.getDoctorId()).orElseThrow(
                () -> new BusinessException("Doctor is not found")));
        consultRepository.save(consultToCreate);
        return consultMapper.map(consultToCreate);
    }

    public void deleteConsult(Long id) {
        Consult consult = consultRepository.findById(id).orElseThrow(
                () -> new BusinessException("Consult is not found"));
        consultRepository.delete(consult);
    }

    public ConsultResponse findConsult(Long id) {
        return consultMapper.map(consultRepository
                .findById(id)
                .orElseThrow(
                        () -> new BusinessException("Consult is not found")));
    }

    public void consultUpdateDate(Long id , ConsultUpdateDate consultUpdate){
        Consult consult =consultRepository.findById(id).orElseThrow(
                ()-> new BusinessException("Consult is not found"));
        consult.setConsultDate(consultUpdate.getConsultDate());
        consultRepository.save(consult);
    }

}
