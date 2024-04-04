package org.pahappa.systems.kimanyisacco.services.impl;

import org.pahappa.systems.kimanyisacco.dao.PatientDao;
import org.pahappa.systems.kimanyisacco.models.Patient;
import org.pahappa.systems.kimanyisacco.services.PatientService;

public class PatientServiceImpl implements PatientService {
    private PatientDao patientDao = new PatientDao();
    @Override
    public void savePatient(Patient patient){
        patientDao.save(patient);
    }
}
