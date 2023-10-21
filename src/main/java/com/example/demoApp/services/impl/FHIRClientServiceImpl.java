package com.example.demoApp.services.impl;

import org.springframework.stereotype.Service;

import com.example.demoApp.services.FHIRClientService;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;

@Service
public class FHIRClientServiceImpl implements FHIRClientService {

    String serverBase = "http://localhost:8090/fhir/";


    public FhirContext getContext() {
        return FhirContext.forR4();
    }

    public IGenericClient getClient() {
        return getContext().newRestfulGenericClient(serverBase);
    }

}
