package ru.itpark.larec.service;

import org.springframework.stereotype.Service;
import ru.itpark.larec.dto.ReagentDto;
import ru.itpark.larec.entity.ReagentEntity;
import ru.itpark.larec.exception.ReagentNotFoundException;
import ru.itpark.larec.repository.ReagentRepository;

@Service
public class ReagentService {
    private final ReagentRepository reagentRepository;
    private final ExperimentService experimentService;

    public ReagentService(ReagentRepository reagentRepository, ExperimentService experimentService) {
        this.reagentRepository = reagentRepository;
        this.experimentService = experimentService;
    }

    public void add(ReagentDto item) {
        ReagentEntity reagentEntity = new ReagentEntity();
        reagentEntity.setExperiment(experimentService.findById(item.getExperimentId()));
        reagentEntity.setName(item.getName());
        reagentEntity.setMolecularWeight(item.getMolecularWeight());
        reagentEntity.setFormula(item.getFormula());
        reagentEntity.setAmountGram(item.getAmountGram());
        reagentEntity.setLinkForDescription(item.getLinkForDescription());
        reagentRepository.save(reagentEntity);
    }

    public ReagentEntity findById(int id) {
        return reagentRepository.findById(id).orElseThrow(ReagentNotFoundException::new);
    }

    public void updateById(ReagentDto reagentDto, int id) {
        ReagentEntity reagent = reagentRepository.findById(id).orElseThrow();
        reagent.setMolecularWeight(reagentDto.getMolecularWeight());
        reagent.setFormula(reagentDto.getFormula());
        reagent.setAmountGram(reagentDto.getAmountGram());
        reagent.setLinkForDescription(reagentDto.getLinkForDescription());
        reagent.setName(reagentDto.getName());
        reagentRepository.save(reagent);
    }

    public void deleteById(int id) {
        reagentRepository.deleteById(id);
    }
}

