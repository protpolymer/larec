package ru.itpark.larec.service;

import org.springframework.stereotype.Service;
import ru.itpark.larec.dto.ResearcherDto;
import ru.itpark.larec.entity.ExperimentEntity;
import ru.itpark.larec.entity.ResearcherEntity;
import ru.itpark.larec.exception.ResearcherNotFoundException;
import ru.itpark.larec.repository.ResearcherRepository;

@Service
public class ResearcherService {
    private final ResearcherRepository researcherRepository;
    private final ExperimentService experimentService;

    public ResearcherService(ResearcherRepository researcherRepository, ExperimentService experimentService) {
        this.researcherRepository = researcherRepository;
        this.experimentService = experimentService;
    }

    public void add(ResearcherDto researcherDto) {
        ResearcherEntity researcher = new ResearcherEntity();
        ExperimentEntity experimentEntity = experimentService.findById(researcherDto.getExperimentId());
        researcher.setName(researcherDto.getName());
        researcher.setAge(researcherDto.getAge());
        researcher.setExperiment(experimentEntity);
        researcherRepository.save(researcher);
    }

    public ResearcherEntity findById(int id) {
        return researcherRepository.findById(id).orElseThrow(ResearcherNotFoundException::new);
    }

    public void updateById(ResearcherDto researcherDto, int id) {
        ResearcherEntity researcher = researcherRepository.findById(id).orElseThrow();
        researcher.setName(researcherDto.getName());
        researcher.setAge(researcherDto.getAge());
        researcherRepository.save(researcher);
    }

    public void deleteById(int id) {
        researcherRepository.deleteById(id);
    }
}
