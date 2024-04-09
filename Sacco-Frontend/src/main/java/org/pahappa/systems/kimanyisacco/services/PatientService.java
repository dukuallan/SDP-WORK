package org.pahappa.systems.kimanyisacco.services;

import org.pahappa.systems.kimanyisacco.dao.PatientDao;
import org.pahappa.systems.kimanyisacco.models.Patient;

import java.util.List;

public interface PatientService {
    public static PatientDao patientDao = new PatientDao();
    public void savePatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatient(String patientId);

    Patient findPatientById(String patientId);

    List<Patient> getAllPatients();

    List<Patient> getPatientsByFacility(String facilityType);

    boolean isPatientExists(long patientId);

    int getTotalPatientCount();
}
