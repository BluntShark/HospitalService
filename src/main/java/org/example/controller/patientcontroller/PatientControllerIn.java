package org.example.controller.patientcontroller;

import org.example.model.address.Address;
import org.example.model.order.Order;
import org.example.model.patient.Patient;

import java.time.LocalDate;
import java.util.List;

public interface PatientControllerIn {
    void addPatient(String name, int age, List<String> illness, String patientID, Address address);

    void addOrder(Patient patient, LocalDate localDate);

    List<Patient> getPatient();

    List<Order> getOrder();

    List<String> displayPatients();

    List<String> displayOrders();
}
