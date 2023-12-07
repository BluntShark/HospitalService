package org.example.service.laboratoryservice;

import org.example.model.analysis.*;
import org.example.model.laboratory.Laboratory;

import java.util.List;
import java.util.Map;

public interface LaboratoryServiceIn {

    void addBiochemicalLaboratory(Laboratory<BiochemicalBloodAnalysis> bloodAnalysisLaboratory);

    void addDefinitiveLaboratory(Laboratory<DefinitiveBloodAnalysis> definitiveLaboratory);

    void addGeneralLaboratory(Laboratory<GeneralBloodAnalysis> generalLaboratory);

    void addHormonalLaboratory(Laboratory<HormonalBloodAnalysis> hormonalLaboratory);

    void addImmunologicalLaboratory(Laboratory<ImmunologicalBloodAnalysis> immunologicalLaboratory);

    List<Laboratory<BiochemicalBloodAnalysis>> getBiochemicalLaboratory();

    List<Laboratory<DefinitiveBloodAnalysis>> getDefinitiveLaboratory();

    List<Laboratory<GeneralBloodAnalysis>> getGeneralLaboratory();

    List<Laboratory<HormonalBloodAnalysis>> getHormonalLaboratory();

    List<Laboratory<ImmunologicalBloodAnalysis>> getImmunologicalLaboratory();
}
