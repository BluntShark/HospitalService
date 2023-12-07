package org.example.service.patientservice;

import org.example.model.order.Order;
import org.example.model.patient.Patient;

import java.util.List;

public interface PatientServiceIn {
    void addPatient(Patient patient);

    void addOrder(Order order);

    List<Patient> getPatient();

    List<Order> getOrder();
}
