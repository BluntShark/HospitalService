package org.example.controller.analysiscontroller;

import org.example.model.order.Order;
import org.example.service.laboratoryservice.LaboratoryService;

import java.time.LocalDate;
import java.util.List;

public interface AnalysisControllerIn {
    void initializationLaboratoryService(LaboratoryService laboratoryService);

    void performBiochemicalAnalysis(Order order, Integer laboratory, LocalDate localDate);

    void performDefinitiveAnalysis(Order order, Integer laboratory, LocalDate localDate);

    void performGeneralAnalysis(Order order, Integer laboratory, LocalDate localDate);

    void performHormonalAnalysis(Order order, Integer laboratory, LocalDate localDate);

    void performImmunologicalAnalysis(Order order, Integer laboratory, LocalDate localDate);

    List<String> displayBiochemicalAnalysis();

    List<String> displayDefinitiveAnalysis();

    List<String> displayGeneralAnalysis();

    List<String> displayHormonalAnalysis();

    List<String> displayImmunologicalAnalysis();
}
