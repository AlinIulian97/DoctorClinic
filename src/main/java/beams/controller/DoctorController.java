package beams.controller;

import beams.model.DoctorRequest;
import beams.model.DoctorResponse;
import beams.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping("/createDoctor")
    public DoctorResponse createDoctor(@RequestBody DoctorRequest doctorRequest) {
        return doctorService.createDoctor(doctorRequest);
    }

    @DeleteMapping("/deleteDoctor/{id}")
    public void deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
    }

}
