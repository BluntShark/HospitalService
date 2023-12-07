package org.example.controller.laboratorycontroller;

import org.example.model.analysis.*;
import org.example.model.laboratory.Laboratory;
import org.example.service.laboratoryservice.LaboratoryService;

import java.util.List;
import java.util.Map;

public class LaboratoryController implements LaboratoryControllerIn {
    private final LaboratoryService laboratoryService;
    public LaboratoryController(LaboratoryService laboratoryService){
        this.laboratoryService = laboratoryService;
    }
    @Override
    public Map<Integer, Laboratory> parseLaboratories(String filePath){
        return laboratoryService.laboratoriesToHashMap(filePath);
    }
    @Override
    public void createBiochemicalLaboratory(String labName, String labNumber, Integer idLaboratory){
        Laboratory<BiochemicalBloodAnalysis>  biochemicalBloodAnalysisLaboratory = new Laboratory<>();
        biochemicalBloodAnalysisLaboratory.setLabName(labName);
        biochemicalBloodAnalysisLaboratory.setLabNumber(labNumber);
        biochemicalBloodAnalysisLaboratory.setIdLaboratory(idLaboratory);
        laboratoryService.addBiochemicalLaboratory(biochemicalBloodAnalysisLaboratory);
    }
    @Override
    public void createDefinitiveLaboratory(String labName, String labNumber, Integer idLaboratory){
        Laboratory<DefinitiveBloodAnalysis>  definitiveBloodAnalysisLaboratory = new Laboratory<>();
        definitiveBloodAnalysisLaboratory.setLabName(labName);
        definitiveBloodAnalysisLaboratory.setLabNumber(labNumber);
        definitiveBloodAnalysisLaboratory.setIdLaboratory(idLaboratory);
        laboratoryService.addDefinitiveLaboratory(definitiveBloodAnalysisLaboratory);
    }
    @Override
    public void createGeneralLaboratory(String labName, String labNumber, Integer idLaboratory){
        Laboratory<GeneralBloodAnalysis>  generalBloodAnalysisLaboratory = new Laboratory<>();
        generalBloodAnalysisLaboratory.setLabName(labName);
        generalBloodAnalysisLaboratory.setLabNumber(labNumber);
        generalBloodAnalysisLaboratory.setIdLaboratory(idLaboratory);
        laboratoryService.addGeneralLaboratory(generalBloodAnalysisLaboratory);
    }
    @Override
    public void createHormonalLaboratory(String labName, String labNumber, Integer idLaboratory){
        Laboratory<HormonalBloodAnalysis>  hormonalBloodAnalysisLaboratory = new Laboratory<>();
        hormonalBloodAnalysisLaboratory.setLabName(labName);
        hormonalBloodAnalysisLaboratory.setLabNumber(labNumber);
        hormonalBloodAnalysisLaboratory.setIdLaboratory(idLaboratory);
        laboratoryService.addHormonalLaboratory(hormonalBloodAnalysisLaboratory);
    }
    @Override
    public void createImmunologicalLaboratory(String labName, String labNumber, Integer idLaboratory){
        Laboratory<ImmunologicalBloodAnalysis>  immunologicalBloodAnalysisLaboratory = new Laboratory<>();
        immunologicalBloodAnalysisLaboratory.setLabName(labName);
        immunologicalBloodAnalysisLaboratory.setLabNumber(labNumber);
        immunologicalBloodAnalysisLaboratory.setIdLaboratory(idLaboratory);
        laboratoryService.addImmunologicalLaboratory(immunologicalBloodAnalysisLaboratory);
    }
    @Override
    public List<Laboratory<BiochemicalBloodAnalysis>> getBiochemicalLaboratory(){
        return laboratoryService.getBiochemicalLaboratory();
    }
    @Override
    public List<Laboratory<DefinitiveBloodAnalysis>> getDefinitiveLaboratory(){
        return laboratoryService.getDefinitiveLaboratory();
    }
    @Override
    public List<Laboratory<GeneralBloodAnalysis>> getGeneralLaboratory(){
        return laboratoryService.getGeneralLaboratory();
    }
    @Override
    public List<Laboratory<HormonalBloodAnalysis>> getHormonalLaboratory(){
        return laboratoryService.getHormonalLaboratory();
    }
    @Override
    public List<Laboratory<ImmunologicalBloodAnalysis>> getImmunologicalLaboratory(){
        return laboratoryService.getImmunologicalLaboratory();
    }
    @Override
    public List<String> displayBiochemicalLaboratory() {
        return laboratoryService.getBiochemicalLaboratory().stream().map(Laboratory<BiochemicalBloodAnalysis>::toString).toList();
    }
    @Override
    public List<String> displayDefinitiveLaboratory() {
        return laboratoryService.getDefinitiveLaboratory().stream().map(Laboratory<DefinitiveBloodAnalysis>::toString).toList();
    }
    @Override
    public List<String> displayGeneralLaboratory() {
        return laboratoryService.getGeneralLaboratory().stream().map(Laboratory<GeneralBloodAnalysis>::toString).toList();
    }

    @Override
    public List<String> displayHormonalLaboratory() {
        return laboratoryService.getHormonalLaboratory().stream().map(Laboratory<HormonalBloodAnalysis>::toString).toList();
    }

    @Override
    public List<String> displayImmunologicalLaboratory() {
        return laboratoryService.getImmunologicalLaboratory().stream().map(Laboratory<ImmunologicalBloodAnalysis>::toString).toList();
    }


}
