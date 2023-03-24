package beams.mapper;

import beams.entity.Consult;
import beams.model.consult.ConsultRequest;
import beams.model.consult.ConsultResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ConsultMapper {

    Consult map(ConsultRequest consultRequest);
    @Mapping(target = "doctorId", source = "doctor.id")
    ConsultResponse map(Consult consult);
}
