package beams.controller;

import beams.model.consult.ConsultRequest;
import beams.model.consult.ConsultResponse;
import beams.model.consult.ConsultUpdateDate;
import beams.service.ConsultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/consult")
public class ConsultController {
    private final ConsultService consultService;

    @PostMapping("/create")
    public ConsultResponse createConsult(@RequestBody ConsultRequest consultRequest){
        return consultService.createConsult(consultRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteConsult(@PathVariable Long id){
        consultService.deleteConsult(id);
    }

    @GetMapping({"{id}"})
    public ConsultResponse findConsult(@PathVariable Long id){
        return consultService.findConsult(id);
    }

    @PatchMapping("/update/{id}")
    public void consultUpdateDate( @RequestBody ConsultUpdateDate consultUpdateDate , @PathVariable Long id){
        consultService.consultUpdateDate(id,consultUpdateDate);
    }
}
