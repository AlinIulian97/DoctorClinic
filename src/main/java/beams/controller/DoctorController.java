package beams.controller;

import beams.model.doctor.DoctorRequest;
import beams.model.doctor.DoctorResponse;
import beams.model.doctor.DoctorUpdate;
import beams.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping("/create")
    public DoctorResponse createDoctor(@RequestBody DoctorRequest doctorRequest) {
        return doctorService.createDoctor(doctorRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(((id)));
    }

    @PatchMapping("/update/{id}")
    public void updateDoctor(@PathVariable Long id, @RequestBody DoctorUpdate doctorUpdate) {
        doctorService.updateDoctor(id, doctorUpdate);
    }

    @GetMapping("{id}")
    public DoctorResponse findDoctor(@PathVariable Long id) {
        return doctorService.findDoctor(id);
    }

}
