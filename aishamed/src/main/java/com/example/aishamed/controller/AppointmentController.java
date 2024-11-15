package com.example.aishamed.controller;

import com.example.aishamed.dto.PatientDto;
import com.example.aishamed.model.Appointment;
import com.example.aishamed.model.Patient;
import com.example.aishamed.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/")
    public ResponseEntity<Appointment> getById(@RequestParam Long id){
        return new ResponseEntity<>(appointmentService.getById(id), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Appointment>> getAll(){
        return new ResponseEntity<>(appointmentService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/get-by-doctor")
    public ResponseEntity<List<Appointment>> getByDoctor(@RequestParam Long doctorId){
        return new ResponseEntity<>(appointmentService.getByDoctor(doctorId), HttpStatus.OK);
    }
    @GetMapping("/get-by-patient")
    public ResponseEntity<List<Appointment>> getByPatient(@RequestParam Long patientId){
        return new ResponseEntity<>(appointmentService.getByPatient(patientId), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<HttpStatus> createAppointment(@RequestParam Long doctorId,
                                                        @RequestParam Long patientId,
                                                        @RequestParam LocalDateTime dateTime){
        appointmentService.createAppointment(doctorId,patientId,dateTime);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<HttpStatus> updateAppointment(@RequestParam Long id, @RequestParam Long doctorId,
                                                        @RequestParam Long patientId,
                                                        @RequestParam LocalDateTime dateTime){
        appointmentService.updateAppointment(id, doctorId, patientId, dateTime);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAppointment(@RequestParam Long id){
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
