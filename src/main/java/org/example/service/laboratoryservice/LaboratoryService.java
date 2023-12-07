package org.example.service.laboratoryservice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.example.model.analysis.*;
import org.example.model.laboratory.Laboratory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class LaboratoryService implements LaboratoryServiceIn {
    final ThreadFactory threadFactory = new ThreadFactoryBuilder()
            .setNameFormat("Лаборатория - %d")
            .setDaemon(true)
            .build();
    final ExecutorService executorService = Executors.newFixedThreadPool(5, threadFactory);
    private final List<Laboratory<BiochemicalBloodAnalysis>> biochemicalLaboratoryList = new ArrayList<>();
    private final List<Laboratory<DefinitiveBloodAnalysis>> definitiveLaboratoryList = new ArrayList<>();
    private final List<Laboratory<GeneralBloodAnalysis>> generalLaboratoryList = new ArrayList<>();
    private final List<Laboratory<HormonalBloodAnalysis>> hormonalLaboratoryList = new ArrayList<>();
    private final List<Laboratory<ImmunologicalBloodAnalysis>> immunologicalLaboratoryList = new ArrayList<>();
    public Map<Integer, Laboratory> laboratoriesToHashMap(String filePath) {
        Map<Integer, Laboratory> resourceMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));
            if (jsonNode.isArray()) {
                for (JsonNode node : jsonNode) {
                    Laboratory laboratory = objectMapper.treeToValue(node, Laboratory.class);
                    resourceMap.put(laboratory.getIdLaboratory(), laboratory);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resourceMap;
    }
    @Override
    public void addBiochemicalLaboratory(Laboratory<BiochemicalBloodAnalysis> bloodAnalysisLaboratory){
        executorService.submit(() -> {
            biochemicalLaboratoryList.add(bloodAnalysisLaboratory);
        });
    }
    @Override
    public void addDefinitiveLaboratory(Laboratory<DefinitiveBloodAnalysis> definitiveLaboratory){
        executorService.submit(() -> {
            definitiveLaboratoryList.add(definitiveLaboratory);
        });
    }
    @Override
    public void addGeneralLaboratory(Laboratory<GeneralBloodAnalysis> generalLaboratory){
        executorService.submit(() -> {
            generalLaboratoryList.add(generalLaboratory);
        });
    }
    @Override
    public void addHormonalLaboratory(Laboratory<HormonalBloodAnalysis> hormonalLaboratory){
        executorService.submit(() -> {
            hormonalLaboratoryList.add(hormonalLaboratory);
        });
    }
    @Override
    public void addImmunologicalLaboratory(Laboratory<ImmunologicalBloodAnalysis> immunologicalLaboratory){
        executorService.submit(() -> {
            immunologicalLaboratoryList.add(immunologicalLaboratory);
        });
    }
    @Override
    public List<Laboratory<BiochemicalBloodAnalysis>> getBiochemicalLaboratory(){
        return biochemicalLaboratoryList;
    }
    @Override
    public List<Laboratory<DefinitiveBloodAnalysis>> getDefinitiveLaboratory() {
        return definitiveLaboratoryList;
    }
    @Override
    public List<Laboratory<GeneralBloodAnalysis>> getGeneralLaboratory() {
        return generalLaboratoryList;
    }
    @Override
    public List<Laboratory<HormonalBloodAnalysis>> getHormonalLaboratory() {
        return hormonalLaboratoryList;
    }
    @Override
    public List<Laboratory<ImmunologicalBloodAnalysis>> getImmunologicalLaboratory() {
        return immunologicalLaboratoryList;
    }
}
