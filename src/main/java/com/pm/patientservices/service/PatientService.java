package com.pm.patientservices.service;


import com.pm.patientservices.Repository.PatientRepo;
import com.pm.patientservices.dto.PatientResponseDTO;
import com.pm.patientservices.mapper.PatientMapper;
import com.pm.patientservices.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public List<PatientResponseDTO> getPatient(){
        List<Patient> patientResponseDTOList = patientRepo.findAll();
        List<PatientResponseDTO> patientResponseDTOList1 = patientResponseDTOList.stream()
                                                            .map(patient -> PatientMapper.toDTO(patient))
                                                            .toList();

        return  patientResponseDTOList1;
    }
}
