package org.example.service.analysisservice;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.example.model.analysis.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class AnalysisService implements AnalysisServiceIn {
    final ThreadFactory threadFactory = new ThreadFactoryBuilder()
            .setNameFormat("Анализ - %d")
            .setDaemon(true)
            .build();
    final ExecutorService executorService = Executors.newFixedThreadPool(5, threadFactory);
    private final List<Analysis> biochemicalAnalysisList = new ArrayList<>();
    private final List<Analysis> definitiveAnalysisList = new ArrayList<>();
    private final List<Analysis> generalAnalysisList = new ArrayList<>();
    private final List<Analysis> hormonalAnalysisList = new ArrayList<>();
    private final List<Analysis> immunologicalAnalysisList = new ArrayList<>();
    @Override
    public void addBiochemicalAnalysis(BiochemicalBloodAnalysis analysis) {
        executorService.submit(() -> {
            biochemicalAnalysisList.add(analysis);
        });
    }
    @Override
    public void addDefinitiveAnalysis(DefinitiveBloodAnalysis analysis) {
        executorService.submit(() -> {
            definitiveAnalysisList.add(analysis);
        });
    }
    @Override
    public void addGeneralAnalysis(GeneralBloodAnalysis analysis) {
        executorService.submit(() -> {
            generalAnalysisList.add(analysis);
        });
    }
    @Override
    public void addHormonalAnalysis(HormonalBloodAnalysis analysis) {
        executorService.submit(() -> {
            hormonalAnalysisList.add(analysis);
        });
    }
    @Override
    public void addImmunologicalAnalysis(ImmunologicalBloodAnalysis analysis) {
        executorService.submit(() -> {
            immunologicalAnalysisList.add(analysis);
        });
    }
    @Override
    public List<Analysis> getBiochemicalAnalysis() { return biochemicalAnalysisList; }
    @Override
    public List<Analysis> getDefinitiveAnalysis() { return definitiveAnalysisList; }
    @Override
    public List<Analysis> getGeneralAnalysis() { return generalAnalysisList; }
    @Override
    public List<Analysis> getHormonalAnalysis() { return hormonalAnalysisList; }
    @Override
    public List<Analysis> getImmunologicalAnalysis() { return immunologicalAnalysisList; }
}
