package org.pahappa.systems.kimanyisacco.services.Hospital;

import org.pahappa.systems.kimanyisacco.models.Patient;
import org.pahappa.systems.kimanyisacco.services.HealthFacility.HealthFacilityFactory;

public class Hospital implements HealthFacilityFactory {
    private String department;
    @Override
    public Patient createPatient(Patient patient) {
        return null;
    }
}
