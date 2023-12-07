package org.example.model.analysis;
import org.example.model.laboratory.Laboratory;
import org.example.model.order.Order;
import org.example.model.patient.Patient;

import java.time.LocalDate;

public abstract class Analysis{
    private  String typeOfAnalysis;
    private Patient patient;
    private LocalDate localDate;
    private Laboratory laboratory;
    private Order order;
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public abstract void doAnalysis();
    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }
    public Laboratory getLaboratory() {
        return laboratory;
    }
    public LocalDate getLocalDate() {
        return localDate;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    public String getTypeOfAnalysis() {
        return typeOfAnalysis;
    }
    public void setTypeOfAnalysis(String typeOfAnalysis) {
        this.typeOfAnalysis = typeOfAnalysis;
    }
    public Patient getPatient(){
        return patient;
    }
    public void setPatient(Patient patient){
        this.patient = patient;
    }
    @Override
    public String toString(){
        return "Analysis [Type of Analysis: "
                + typeOfAnalysis
                + ", "
                + getOrder()
                + ", Date of Analysis: "
                + getLocalDate() +", "
                + getLaboratory()
                + "]";
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == this.getClass();
    }
}
