package org.pahappa.systems.kimanyisacco.services.Pharmacy;

import org.pahappa.systems.kimanyisacco.models.Patient;
import org.pahappa.systems.kimanyisacco.services.HealthFacility.HealthFacilityFactory;

public class Pharmacy implements HealthFacilityFactory {
    private String licenseNumber;
    @Override
    public Patient createPatient(Patient patient) {
        return null;
    }
}
