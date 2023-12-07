package org.example.controller.laboratorycontroller;

import org.example.model.analysis.*;
import org.example.model.laboratory.Laboratory;

import java.util.List;
import java.util.Map;

public interface LaboratoryControllerIn {
    public Map<Integer, Laboratory> parseLaboratories(String filePath);
    void createBiochemicalLaboratory(String labName, String labNumber, Integer idLaboratory);

    void createDefinitiveLaboratory(String labName, String labNumber, Integer idLaboratory);

    void createGeneralLaboratory(String labName, String labNumber, Integer idLaboratory);

    void createHormonalLaboratory(String labName, String labNumber, Integer idLaboratory);

    void createImmunologicalLaboratory(String labName, String labNumber, Integer idLaboratory);

    List<Laboratory<BiochemicalBloodAnalysis>> getBiochemicalLaboratory();

    List<Laboratory<DefinitiveBloodAnalysis>> getDefinitiveLaboratory();

    List<Laboratory<GeneralBloodAnalysis>> getGeneralLaboratory();

    List<Laboratory<HormonalBloodAnalysis>> getHormonalLaboratory();

    List<Laboratory<ImmunologicalBloodAnalysis>> getImmunologicalLaboratory();

    List<String> displayBiochemicalLaboratory();

    List<String> displayDefinitiveLaboratory();

    List<String> displayGeneralLaboratory();

    List<String> displayHormonalLaboratory();

    List<String> displayImmunologicalLaboratory();
}
