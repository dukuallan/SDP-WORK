package org.pahappa.systems.kimanyisacco.services.impl;

import org.pahappa.systems.kimanyisacco.models.Patient;
import org.pahappa.systems.kimanyisacco.services.ClinicPatientService;
import org.pahappa.systems.kimanyisacco.services.PatientService;

import java.util.Date;
import java.util.List;

public class ClinicPatientServiceImpl implements ClinicPatientService {
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
    public void scheduleAppointment(long patientId, Date appointmentDate, String doctorName) {

    }

    @Override
    public List<Patient> getAppointmentsByDate(Date appointmentDate) {
        return null;
    }

    @Override
    public List<Patient> getAppointmentsByDoctor(String doctorName) {
        return null;
    }
}
