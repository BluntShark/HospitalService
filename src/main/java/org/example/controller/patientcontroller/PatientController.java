package org.example.controller.patientcontroller;

import org.example.model.address.Address;
import org.example.model.order.Order;
import org.example.model.patient.Patient;
import org.example.service.patientservice.PatientService;

import java.time.LocalDate;
import java.util.List;

public class PatientController implements PatientControllerIn {
    private final PatientService patientService;
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }
    @Override
    public void addPatient(String name, int age, List<String> illness, String patientID, Address address){
        Patient patient = new Patient(name, age, illness, patientID);
        patient.setAddress(address);
        patientService.addPatient(patient);
    }
    @Override
    public void addOrder(Patient patient, LocalDate localDate){
        Order order = new Order(patient, localDate);
        order.setPatient(patient);
        patientService.addOrder(order);
    }
    @Override
    public List<Patient> getPatient(){
        return patientService.getPatient();
    }
    @Override
    public List<Order> getOrder(){
        return patientService.getOrder();
    }
    @Override
    public List<String> displayPatients() {
        return patientService.getPatient().stream().map(Patient::toString).toList();
    }
    @Override
    public List<String> displayOrders() {
        return patientService.getOrder().stream().map(Order::toString).toList();
    }
}
