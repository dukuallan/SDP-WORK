package org.pahappa.systems.kimanyisacco.services.impl;

import org.pahappa.systems.kimanyisacco.dao.PatientDao;
import org.pahappa.systems.kimanyisacco.models.Patient;
import org.pahappa.systems.kimanyisacco.services.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    private PatientDao patientDao = new PatientDao();
    @Override
    public void savePatient(Patient patient){
        patientDao.save(patient);
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
}
