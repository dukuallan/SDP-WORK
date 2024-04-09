package org.pahappa.systems.kimanyisacco.services;

import org.pahappa.systems.kimanyisacco.models.Patient;

import java.util.Date;
import java.util.List;

public interface ClinicPatientService extends PatientService {
    void scheduleAppointment(long patientId, Date appointmentDate, String doctorName);

    List<Patient> getAppointmentsByDate(Date appointmentDate);

    List<Patient> getAppointmentsByDoctor(String doctorName);
}
