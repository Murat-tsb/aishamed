package com.example.aishamed.LoginAndRegistration;

import com.example.aishamed.controller.PatientController;
import com.example.aishamed.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final PatientRepository patientRepository;

    public LoginController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @GetMapping("/")
    public ResponseEntity<Boolean> whoIsThis(@RequestParam String email){
        Boolean amIPatient = false;
        if (Objects.nonNull(patientRepository.getByEmail(email))){amIPatient = true;}
        return new ResponseEntity<>(amIPatient, HttpStatus.OK);
    }

}
