package com.example.demoApp.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoApp.services.PatientService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/fhir")
public class PatientRestController {

    @Autowired
    PatientService patientService;

    @Operation(summary = "Get all patients")
    @GetMapping(value = "/patient", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> all() {
        try {
            return new ResponseEntity<>(patientService.getPatientAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
