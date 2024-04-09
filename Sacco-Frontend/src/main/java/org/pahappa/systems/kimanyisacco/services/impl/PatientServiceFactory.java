package org.pahappa.systems.kimanyisacco.services.impl;

import org.pahappa.systems.kimanyisacco.services.PatientService;
import org.pahappa.systems.kimanyisacco.constants.FacilityType;

public class PatientServiceFactory {
    public static PatientService createService(String facilityType) {
        if (facilityType.equals(FacilityType.HOSPITAL.toString())) {
            return new HospitalPatientServiceImpl();
        } else if (facilityType.equals(FacilityType.CLINIC.toString())) {
            return new ClinicPatientServiceImpl();
        } else if (facilityType.equals(FacilityType.PHARMACY.toString())) {
            return new PharmacyPatientServiceImpl();
        } else {
            throw new IllegalArgumentException("Invalid facility type");
        }
    }
}