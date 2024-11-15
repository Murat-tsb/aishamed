package com.example.aishamed.controller;

import com.example.aishamed.dto.PatientDto;
import com.example.aishamed.model.Drugs;
import com.example.aishamed.model.Patient;
import com.example.aishamed.service.DrugService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drugs")
public class DrugController {
    private final DrugService drugService;

    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping("/")
    public ResponseEntity<Drugs> getById(@RequestParam Long id){
        return new ResponseEntity<>(drugService.getById(id), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Drugs>> getAll(){
        return new ResponseEntity<>(drugService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<HttpStatus> createDrug(@RequestBody Drugs drugs){
        drugService.createDrug(drugs);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<HttpStatus> updatePatient(@RequestParam Long id, @RequestBody Drugs drugs){
        drugService.updateDrug(id, drugs);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
