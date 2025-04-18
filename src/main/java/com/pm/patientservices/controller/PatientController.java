package com.pm.patientservices.controller;

import com.pm.patientservices.dto.PatientResponseDTO;
import com.pm.patientservices.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")

public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService=patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients(){
        List<PatientResponseDTO> patient= patientService.getPatient();
        return ResponseEntity.ok().body(patient);
    }

//    @GetMapping("/email/{mail}")
////    @RequestMapping("/{id}")
//    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable String mail){
////        if(patientService.getPatient().contains(mail)){
////            return ResponseEntity.ok().body(patientService.getPatient().get(Integer.parseInt(mail)));
////        }
////        return ResponseEntity.notFound().build();
//        Optional<PatientResponseDTO> patient = patientService.getPatientByEmail(mail);
//
//        return patient.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }

}
