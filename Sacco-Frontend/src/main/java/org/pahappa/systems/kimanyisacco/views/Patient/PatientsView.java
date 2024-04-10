package org.pahappa.systems.kimanyisacco.views.Patient;

import org.pahappa.systems.kimanyisacco.models.Patient;
import org.pahappa.systems.kimanyisacco.services.PatientService;
import org.pahappa.systems.kimanyisacco.services.impl.HospitalPatientServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "patientsView")
@SessionScoped
public class PatientsView {
    private List<Patient> dataModels;
    private PatientService patientService;

    @PostConstruct
    public void init(){
        patientService = new HospitalPatientServiceImpl();
        this.dataModels = patientService.getAllPatients();
        System.out.println("The Size of the data model's list is: "+this.dataModels.size());
    }

    public void assignService(Patient patient){
        System.out.println("Patients facility type is:"+patient.getFacilityType());
    }

    public List<Patient> getDataModels() {
        return dataModels;
    }

    public void setDataModels(List<Patient> dataModels) {
        this.dataModels = dataModels;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

}
