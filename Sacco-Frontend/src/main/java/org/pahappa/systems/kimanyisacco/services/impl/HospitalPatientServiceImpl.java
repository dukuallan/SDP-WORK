package org.pahappa.systems.kimanyisacco.services.impl;

import org.pahappa.systems.kimanyisacco.models.Patient;
import org.pahappa.systems.kimanyisacco.services.HospitalPatientService;
import org.pahappa.systems.kimanyisacco.services.PatientService;

import java.util.Date;
import java.util.List;

public class HospitalPatientServiceImpl implements HospitalPatientService {
    @Override
    public void savePatient(Patient patient) {
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
     return patientDao.getAllPatients();
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
    public void admitPatient(long patientId, Date admissionDate) {

    }

    @Override
    public void dischargePatient(long patientId, Date dischargeDate) {

    }

    @Override
    public List<Patient> getAdmittedPatients() {
        return null;
    }

    @Override
    public List<Patient> getDischargedPatients() {
        return null;
    }

    @Override
    public List<Patient> getPatientsByWard(String wardName) {
        return null;
    }
}
