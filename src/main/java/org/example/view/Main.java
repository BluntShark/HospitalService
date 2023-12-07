package org.example.view;

import org.example.controller.analysiscontroller.AnalysisController;
import org.example.controller.laboratorycontroller.LaboratoryController;
import org.example.controller.patientcontroller.PatientController;

import org.example.model.address.Address;

import org.example.service.analysisservice.AnalysisService;
import org.example.service.laboratoryservice.LaboratoryService;
import org.example.service.patientservice.PatientService;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.concurrent.*;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class Main {
    public static void main(String[] args) {
        final ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("Main - %d")
                .setDaemon(true)
                .build();

        final ExecutorService executorService = Executors.newFixedThreadPool(3, threadFactory);

        Address address1 = new Address("Russia", "Khabarovsk", "Kim-U-Chena", "12");
        Address address2 = new Address("Russia", "Ufa", "Lenina", "21");
        Address address3 = new Address("Russia", "Omsk", "NeKrasova", "109");

        AnalysisService analysisService = new AnalysisService();
        AnalysisController analysisController = new AnalysisController(analysisService);

        LaboratoryService laboratoryService = new LaboratoryService();
        LaboratoryController laboratoryController = new LaboratoryController(laboratoryService);
        analysisController.initializationLaboratoryService(laboratoryService);

        PatientService patientService = new PatientService();
        PatientController patientController = new PatientController(patientService);



        laboratoryController.createBiochemicalLaboratory("IK-15", "01", 1);
        laboratoryController.createDefinitiveLaboratory("AI-10", "02", 1);
        laboratoryController.createGeneralLaboratory("LO-07", "03", 1);
        laboratoryController.createHormonalLaboratory("AQ-21", "04", 1);
        laboratoryController.createImmunologicalLaboratory("OS-05", "05", 1);
        laboratoryController.createBiochemicalLaboratory("IK-14", "02", 2);

        patientController.addPatient("Egor", 23, new ArrayList<>(){{ add("Анемия"); add ("Грипп"); }}, "001", address1);
        patientController.addPatient("Elena", 29, new ArrayList<>(){{ add("Гастрит"); }}, "002", address2);
        patientController.addPatient("Alexander", 34, new ArrayList<>(){{ add("Геморрой"); add ("Сколиоз"); }}, "003", address3);


        patientController.addOrder(patientController.getPatient().get(0), LocalDate.of(2023, 2, 10));
        patientController.addOrder(patientController.getPatient().get(1), LocalDate.of(2023, 2, 10));
        patientController.addOrder(patientController.getPatient().get(2), LocalDate.of(2023, 2, 10));

        analysisController.performBiochemicalAnalysis(patientController.getOrder().get(0), 0, LocalDate.of(2023, 2, 14));
        analysisController.performHormonalAnalysis(patientController.getOrder().get(1), 0, LocalDate.of(2023, 2, 13));
        analysisController.performGeneralAnalysis(patientController.getOrder().get(2), 0, LocalDate.of(2023, 2, 15));

        try {
            System.out.println(executorService.submit(analysisController::displayBiochemicalAnalysis).get());
            System.out.println(executorService.submit(analysisController::displayHormonalAnalysis).get());
            System.out.println(executorService.submit(analysisController::displayGeneralAnalysis).get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}