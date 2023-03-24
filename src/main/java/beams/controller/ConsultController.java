package beams.controller;

import beams.model.consult.ConsultRequest;
import beams.model.consult.ConsultResponse;
import beams.service.ConsultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/consult")
public class ConsultController {
    private final ConsultService consultService;

    @PostMapping("/create")
    public ConsultResponse createConsult(@RequestBody ConsultRequest consultRequest){
        return consultService.createConsult(consultRequest);
    }
}
