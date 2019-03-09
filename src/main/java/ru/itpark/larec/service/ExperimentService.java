package ru.itpark.larec.service;

import org.springframework.stereotype.Service;
import ru.itpark.larec.dto.ExperimentDto;
import ru.itpark.larec.entity.*;
import ru.itpark.larec.exception.ExperimentNotFoundException;
import ru.itpark.larec.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperimentService {
    private final ExperimentRepository experimentRepository;
    private final ReagentRepository reagentRepository;
    private final InstrumentationRepository instrumentationRepository;
    private final ResearcherRepository researcherRepository;
    private final ProductRepository productRepository;

    public ExperimentService(ExperimentRepository experimentRepository, ReagentRepository reagentRepository, InstrumentationRepository instrumentationRepository, ResearcherRepository researcherRepository, ProductRepository productRepository) {
        this.experimentRepository = experimentRepository;
        this.reagentRepository = reagentRepository;
        this.instrumentationRepository = instrumentationRepository;
        this.researcherRepository = researcherRepository;
        this.productRepository = productRepository;
    }

    public List<ExperimentEntity> findAll() {
        return experimentRepository.findAll();
    }

    public ExperimentEntity findById(int id) {
        ExperimentEntity experiment = experimentRepository.findById(id).orElseThrow(ExperimentNotFoundException::new);
        List<ReagentEntity> reagentResult = new ArrayList<>();
        for (ReagentEntity reagent : reagentRepository.findAll()) {
            if (reagent.getExperiment() == experiment) {
                reagentResult.add(reagent);
            }
        }
        experiment.setReagents(reagentResult);

        List<InstrumentationEntity> instrumentationResult = new ArrayList<>();
        for (InstrumentationEntity instrumentation : instrumentationRepository.findAll()) {
            if (instrumentation.getExperiment() == experiment) {
                instrumentationResult.add(instrumentation);
            }
        }
        experiment.setInstrumentations(instrumentationResult);

        List<ResearcherEntity> researcherResult = new ArrayList<>();
        for (ResearcherEntity researcher : researcherRepository.findAll()) {
            if (researcher.getExperiment() == experiment) {
                researcherResult.add(researcher);
            }
        }
        experiment.setResearchers(researcherResult);

        List<ProductEntity> productResult = new ArrayList<>();
        for (ProductEntity product : productRepository.findAll()) {
            if (product.getExperiment() == experiment) {
                productResult.add(product);
            }
        }
        experiment.setProducts(productResult);
        return experiment;
    }

    public void add(ExperimentEntity experiment) {
        experimentRepository.save(experiment);
    }

    public void update(ExperimentDto experimentDto, int id) {
        ExperimentEntity experiment = experimentRepository.findById(id).orElseThrow();
        experiment.setDate(experimentDto.getDate());
        experiment.setName(experimentDto.getName());
        experiment.setReaction(experimentDto.getReaction());
        experiment.setProcessConditions(experimentDto.getProcessConditions());
        experiment.setDescription(experimentDto.getDescription());
        experiment.setConclusion(experimentDto.getConclusion());
        experimentRepository.save(experiment);
    }

    public void deleteById(int id) {
        ExperimentEntity experiment = experimentRepository.findById(id).orElseThrow(ExperimentNotFoundException::new);
        for (ReagentEntity reagent : reagentRepository.findAll()) {
            if (reagent.getExperiment() == experiment) {
                reagentRepository.delete(reagent);
            }
        }
        for (InstrumentationEntity instrumentation : instrumentationRepository.findAll()) {
            if (instrumentation.getExperiment() == experiment) {
                instrumentationRepository.delete(instrumentation);
            }
        }
        for (ResearcherEntity researcher : researcherRepository.findAll()) {
            if (researcher.getExperiment() == experiment) {
                researcherRepository.delete(researcher);
            }
        }
        for (ProductEntity product : productRepository.findAll()) {
            if (product.getExperiment() == experiment) {
                productRepository.delete(product);
            }
        }

        experimentRepository.deleteById(id);
    }

    public List<ExperimentEntity> findByName(String name) {
        return experimentRepository.findAllByNameContainsIgnoreCaseOrderByNameDesc(name);
    }
}
