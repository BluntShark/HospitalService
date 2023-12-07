package org.example.service.analysisservice;

import org.example.model.analysis.*;

import java.util.List;

public interface AnalysisServiceIn {
    void addBiochemicalAnalysis(BiochemicalBloodAnalysis analysis);

    void addDefinitiveAnalysis(DefinitiveBloodAnalysis analysis);

    void addGeneralAnalysis(GeneralBloodAnalysis analysis);

    void addHormonalAnalysis(HormonalBloodAnalysis analysis);

    void addImmunologicalAnalysis(ImmunologicalBloodAnalysis analysis);

    List<Analysis> getBiochemicalAnalysis();

    List<Analysis> getDefinitiveAnalysis();

    List<Analysis> getGeneralAnalysis();

    List<Analysis> getHormonalAnalysis();

    List<Analysis> getImmunologicalAnalysis();
}
