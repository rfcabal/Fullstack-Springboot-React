package com.example.demoApp.services.impl;

import org.hl7.fhir.instance.model.api.IBaseBundle;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demoApp.services.FHIRClientService;
import com.example.demoApp.services.PatientService;

import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.parser.IParser;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    FHIRClientService fhirClient;

    static final Include INCLUDE_ALL = IBaseResource.INCLUDE_ALL;

    @Cacheable(value = "patients")
    public String getPatientAll() {

        IParser iParser = fhirClient.getContext().newJsonParser();
        IBaseBundle patientBundle = fhirClient.getClient().search().forResource(Patient.class)
                .include(INCLUDE_ALL).execute();

        return iParser.encodeResourceToString(patientBundle);
    }

}
