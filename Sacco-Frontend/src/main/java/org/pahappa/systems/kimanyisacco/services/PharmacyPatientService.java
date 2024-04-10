package org.pahappa.systems.kimanyisacco.services;

import org.pahappa.systems.kimanyisacco.constants.Medication;
import org.pahappa.systems.kimanyisacco.models.Patient;

import java.util.List;

public interface PharmacyPatientService extends PatientService {
    void dispenseMedication(long patientId, List<Medication> medications);
    List<Patient> getMedicationDispensedPatients();
}
