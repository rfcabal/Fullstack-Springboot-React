package com.example.demoApp.services;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;

public interface FHIRClientService {

    public FhirContext getContext();

    public IGenericClient getClient();
    
}
