package org.example.service.patientservice;

import org.example.model.order.Order;
import org.example.model.patient.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientService implements PatientServiceIn {
    private final List<Patient> patientList = new ArrayList<>();
    private final List<Order> orderList = new ArrayList<>();
    @Override
    public void addPatient(Patient patient){patientList.add(patient); }
    @Override
    public void addOrder(Order order){orderList.add(order); }
    @Override
    public List<Patient> getPatient(){
        return patientList;
    }
    @Override
    public List<Order> getOrder(){
        return orderList;
    }
}
