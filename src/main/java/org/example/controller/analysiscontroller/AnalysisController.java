package org.example.controller.analysiscontroller;

import org.example.model.analysis.*;
import org.example.model.order.Order;
import org.example.service.analysisservice.AnalysisService;
import org.example.service.laboratoryservice.LaboratoryService;

import java.time.LocalDate;
import java.util.List;

public class AnalysisController implements AnalysisControllerIn {
    private final AnalysisService analysisService;
    private LaboratoryService laboratoryService;
    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }
    @Override
    public void initializationLaboratoryService(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }
    @Override
    public void performBiochemicalAnalysis(Order order, Integer laboratory, LocalDate localDate) {
        BiochemicalBloodAnalysis biochemicalBloodAnalysis = new BiochemicalBloodAnalysis();
        biochemicalBloodAnalysis.doAnalysis();
        biochemicalBloodAnalysis.setTypeOfAnalysis("Биохимический анализ крови");
        biochemicalBloodAnalysis.setOrder(order);
        biochemicalBloodAnalysis.setLaboratory(laboratoryService.getBiochemicalLaboratory().get(laboratory));
        biochemicalBloodAnalysis.setLocalDate(localDate);
        analysisService.addBiochemicalAnalysis(biochemicalBloodAnalysis);
    }
    @Override
    public void performDefinitiveAnalysis(Order order, Integer laboratory, LocalDate localDate) {
        DefinitiveBloodAnalysis definitiveAnalysis = new DefinitiveBloodAnalysis();
        definitiveAnalysis.doAnalysis();
        definitiveAnalysis.setTypeOfAnalysis("Определительный анализ крови");
        definitiveAnalysis.setOrder(order);
        definitiveAnalysis.setLaboratory(laboratoryService.getDefinitiveLaboratory().get(laboratory));
        definitiveAnalysis.setLocalDate(localDate);
        analysisService.addDefinitiveAnalysis(definitiveAnalysis);
    }
    @Override
    public void performGeneralAnalysis(Order order, Integer laboratory, LocalDate localDate) {
        GeneralBloodAnalysis generalAnalysis = new GeneralBloodAnalysis();
        generalAnalysis.doAnalysis();
        generalAnalysis.setTypeOfAnalysis("Общий анализ крови");
        generalAnalysis.setOrder(order);
        generalAnalysis.setLaboratory(laboratoryService.getGeneralLaboratory().get(laboratory));
        generalAnalysis.setLocalDate(localDate);
        analysisService.addGeneralAnalysis(generalAnalysis);
    }
    @Override
    public void performHormonalAnalysis(Order order, Integer laboratory, LocalDate localDate) {
        HormonalBloodAnalysis hormonalAnalysis = new HormonalBloodAnalysis();
        hormonalAnalysis.doAnalysis();
        hormonalAnalysis.setTypeOfAnalysis("Гормональный анализ крови");
        hormonalAnalysis.setOrder(order);
        hormonalAnalysis.setLaboratory(laboratoryService.getHormonalLaboratory().get(laboratory));
        hormonalAnalysis.setLocalDate(localDate);
        analysisService.addHormonalAnalysis(hormonalAnalysis);
    }
    @Override
    public void performImmunologicalAnalysis(Order order, Integer laboratory, LocalDate localDate) {
        ImmunologicalBloodAnalysis immunologicalAnalysis = new ImmunologicalBloodAnalysis();
        immunologicalAnalysis.doAnalysis();
        immunologicalAnalysis.setTypeOfAnalysis("Иммунологический анализ крови");
        immunologicalAnalysis.setOrder(order);
        immunologicalAnalysis.setLaboratory(laboratoryService.getImmunologicalLaboratory().get(laboratory));
        immunologicalAnalysis.setLocalDate(localDate);
        analysisService.addImmunologicalAnalysis(immunologicalAnalysis);
    }
    @Override
    public List<String> displayBiochemicalAnalysis() {
        return analysisService.getBiochemicalAnalysis().stream().map(Analysis::toString).toList();
    }
    @Override
    public List<String> displayDefinitiveAnalysis() {
        return analysisService.getDefinitiveAnalysis().stream().map(Analysis::toString).toList();
    }
    @Override
    public List<String> displayGeneralAnalysis() {
        return analysisService.getGeneralAnalysis().stream().map(Analysis::toString).toList();
    }
    @Override
    public List<String> displayHormonalAnalysis() {
        return analysisService.getHormonalAnalysis().stream().map(Analysis::toString).toList();
    }
    @Override
    public List<String> displayImmunologicalAnalysis() {
        return analysisService.getImmunologicalAnalysis().stream().map(Analysis::toString).toList();
    }

}
