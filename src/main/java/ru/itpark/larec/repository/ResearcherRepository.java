package ru.itpark.larec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.larec.entity.ResearcherEntity;

public interface ResearcherRepository extends JpaRepository<ResearcherEntity, Integer> {
}
