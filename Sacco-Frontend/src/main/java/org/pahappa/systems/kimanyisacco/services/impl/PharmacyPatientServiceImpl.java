package org.pahappa.systems.kimanyisacco.services.impl;

import org.pahappa.systems.kimanyisacco.constants.Medication;
import org.pahappa.systems.kimanyisacco.models.Patient;
import org.pahappa.systems.kimanyisacco.services.PatientService;
import org.pahappa.systems.kimanyisacco.services.PharmacyPatientService;

import java.util.List;

public class PharmacyPatientServiceImpl implements PharmacyPatientService {
    @Override
    public void savePatient(Patient patient) {

    }

    @Override
    public void updatePatient(Patient patient) {

    }

    @Override
    public void deletePatient(String patientId) {

    }

    @Override
    public Patient findPatientById(String patientId) {
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        return null;
    }

    @Override
    public List<Patient> getPatientsByFacility(String facilityType) {
        return null;
    }

    @Override
    public boolean isPatientExists(long patientId) {
        return false;
    }

    @Override
    public int getTotalPatientCount() {
        return 0;
    }

    @Override
    public void dispenseMedication(long patientId, List<Medication> medications) {

    }

    @Override
    public List<Patient> getMedicationDispensedPatients() {
        return null;
    }
}
