package com.example.aishamed.controller;

import com.example.aishamed.dto.DoctorDto;
import com.example.aishamed.model.Doctor;
import com.example.aishamed.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/")
    public ResponseEntity<DoctorDto> getById(@RequestParam Long id){
        return new ResponseEntity<>(doctorService.getById(id), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<DoctorDto>> getAll(){
        return new ResponseEntity<>(doctorService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/get-by-clinic")
    public ResponseEntity<List<DoctorDto>> getByClinic(@RequestParam Long clinicId){
        return new ResponseEntity<>(doctorService.getByClinic(clinicId), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<HttpStatus> createDoctor(@RequestBody Doctor doctor){
        doctorService.createDoctor(doctor);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<HttpStatus> updateDoctor(@RequestParam Long id, @RequestBody Doctor doctor){
        doctorService.updateDoctor(id, doctor);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteDoctor(@RequestParam Long id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
