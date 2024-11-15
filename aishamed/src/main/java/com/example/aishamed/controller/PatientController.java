package com.example.aishamed.controller;

import com.example.aishamed.dto.PatientDto;
import com.example.aishamed.model.Patient;
import com.example.aishamed.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public ResponseEntity<PatientDto> getById(@RequestParam Long id){
        return new ResponseEntity<>(patientService.getById(id), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<PatientDto>> getAll(){
        return new ResponseEntity<>(patientService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/get-by-drugs")
    public ResponseEntity<List<PatientDto>> getByDrugs(@RequestParam Long drugId){
        return new ResponseEntity<>(patientService.getByDrugs(drugId), HttpStatus.OK);
    }
    @GetMapping("/get-by-status")
    public ResponseEntity<List<PatientDto>> getByStatus(@RequestParam Long statusId){
        return new ResponseEntity<>(patientService.getByStatus(statusId), HttpStatus.OK);
    }
    @GetMapping("/get-by-doctor")
    public ResponseEntity<List<PatientDto>> getByDoctor(@RequestParam Long doctorId){
        return new ResponseEntity<>(patientService.getByDoctor(doctorId), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<HttpStatus> createPatient(@RequestBody Patient patient){
        patientService.createPatient(patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<HttpStatus> updatePatient(@RequestParam Long id, @RequestBody Patient patient){
        patientService.updatePatient(id, patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deletePatient(@RequestParam Long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
