package ru.itpark.larec.service;

import org.springframework.stereotype.Service;
import ru.itpark.larec.dto.InstrumentationDto;
import ru.itpark.larec.entity.InstrumentationEntity;
import ru.itpark.larec.exception.InstrumentationNotFoundException;
import ru.itpark.larec.repository.InstrumentationRepository;

@Service
public class InstrumentationService {
    private final InstrumentationRepository instrumentationRepository;
    private final ExperimentService experimentService;

    public InstrumentationService(InstrumentationRepository instrumentationRepository, ExperimentService experimentService) {
        this.instrumentationRepository = instrumentationRepository;
        this.experimentService = experimentService;
    }

    public void add(InstrumentationDto item) {
        InstrumentationEntity instrumentationEntity = new InstrumentationEntity();
        instrumentationEntity.setExperiment(experimentService.findById(item.getExperimentId()));
        instrumentationEntity.setName(item.getName());
        instrumentationRepository.save(instrumentationEntity);
    }

    public InstrumentationEntity findById(int id) {
        return instrumentationRepository.findById(id).orElseThrow(InstrumentationNotFoundException::new);
    }

    public void updateById(InstrumentationDto instrumentationDto, int id) {
        InstrumentationEntity instrumentation = instrumentationRepository.findById(id).orElseThrow();
        instrumentation.setName(instrumentationDto.getName());
        instrumentationRepository.save(instrumentation);
    }

    public void deleteById(int id) {
        instrumentationRepository.deleteById(id);
    }
}
