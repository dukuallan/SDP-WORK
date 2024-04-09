package org.pahappa.systems.kimanyisacco.services;

import org.pahappa.systems.kimanyisacco.models.Patient;

import java.util.Date;
import java.util.List;

public interface HospitalPatientService extends PatientService{
    void admitPatient(long patientId, Date admissionDate);

    void dischargePatient(long patientId, Date dischargeDate);

    List<Patient> getAdmittedPatients();

    List<Patient> getDischargedPatients();

    List<Patient> getPatientsByWard(String wardName);
}
