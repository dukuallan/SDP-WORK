package org.pahappa.systems.kimanyisacco.services.Clinic;

import org.pahappa.systems.kimanyisacco.models.Patient;
import org.pahappa.systems.kimanyisacco.services.HealthFacility.HealthFacilityFactory;

public class Clinic implements HealthFacilityFactory {
    private String specialization;
    @Override
    public Patient createPatient(Patient patient) {
        return null;
    }
}
