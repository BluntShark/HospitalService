package org.example.model.order;

import org.example.model.patient.Patient;

import java.time.LocalDate;

public class Order {
    private Patient patient;
    private LocalDate localDate;
    private String patientID;
    public String getPatientID() {
        return patientID;
    }
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    public Patient getPatient(){ return patient; }
    public void setPatient(Patient patient){ this.patient = patient; }
    public LocalDate getLocalDate(){
        return localDate;
    };
    public void setLocalDate(LocalDate localDate){
        this.localDate = localDate;
    }
    public Order(Patient patient, LocalDate localDate){
        this.patient = patient;
        this.localDate = localDate;
        this.patientID = patient.getPatientID();
    }

    @Override
    public String toString() {
        return "Order [" +
                "Patient: " + getPatient() +
                ", Date: " + localDate +
                ", PatientID: " + patientID +
                "]";
    }
}
