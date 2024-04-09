package org.pahappa.systems.kimanyisacco.services.HealthFacility;

import org.pahappa.systems.kimanyisacco.models.Patient;

public interface HealthFacilityFactory {
//    private String name;
//    private String location;

    public abstract Patient createPatient(Patient patient);
}
