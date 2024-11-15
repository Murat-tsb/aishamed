package com.example.aishamed.service;

import com.example.aishamed.model.Drugs;
import com.example.aishamed.repository.DrugsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DrugService {
    private final DrugsRepository drugsRepository;

    public DrugService(DrugsRepository drugsRepository) {
        this.drugsRepository = drugsRepository;
    }

    public List<Drugs> getAll (){
        return drugsRepository.findAll();
    }
    public Drugs getById(Long id){
        return drugsRepository.getReferenceById(id);
    }
    public void updateDrug(Long id, Drugs drugs){
        Drugs drugsNew = drugsRepository.getReferenceById(id);
        if (Objects.nonNull(drugs.getAmount())){drugsNew.setAmount(drugs.getAmount());}
        if (Objects.nonNull(drugs.getName())){drugsNew.setName(drugs.getName());}
        if (Objects.nonNull(drugs.getDescription())){drugsNew.setDescription(drugs.getDescription());}
        if (Objects.nonNull(drugs.getInstruction())){drugsNew.setInstruction(drugs.getInstruction());}
        drugsRepository.save(drugsNew);
    }
    public void createDrug(Drugs drugs){
        drugsRepository.save(drugs);
    }
}
