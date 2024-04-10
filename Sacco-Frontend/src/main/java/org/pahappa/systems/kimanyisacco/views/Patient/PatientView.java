package org.pahappa.systems.kimanyisacco.views.Patient;

import org.pahappa.systems.kimanyisacco.constants.District;
import org.pahappa.systems.kimanyisacco.constants.FacilityType;
import org.pahappa.systems.kimanyisacco.constants.Gender;
import org.pahappa.systems.kimanyisacco.constants.Medication;
import org.pahappa.systems.kimanyisacco.models.Patient;
import org.pahappa.systems.kimanyisacco.services.PatientService;
import org.pahappa.systems.kimanyisacco.services.impl.PatientServiceFactory;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "patients")
@SessionScoped
public class PatientView {

    private Patient patient;
    private PatientService patientService;
    public FacesMessage message;

    public PatientView(){
        this.patient = new Patient();
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }
    public Patient getPatient(){
        return this.patient;
    }

    public List<Gender> getGenders() {
        return Arrays.asList(Gender.values());
    }

    public List<District> getDistricts() {
        return Arrays.asList(District.values());
    }

    public List<Medication> getMedications() {
        return Arrays.asList(Medication.values());
    }

    public List<FacilityType> getFacilityTypes() {
        return Arrays.asList(FacilityType.values());
    }


    public void savePatient(){
        this.patientService = PatientServiceFactory.createService(this.patient.getFacilityType());
        System.out.println("Patient's Service Impl is: "+patientService.getClass());
        this.patientService.savePatient(patient);
        addFlashMessage(FacesMessage.SEVERITY_INFO, "Success", "Successfully saved a patient");
    }

    private void addFlashMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Flash flash = facesContext.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        facesContext.addMessage("messages", new FacesMessage(severity, summary, detail));
    }



}
