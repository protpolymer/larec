package ru.itpark.larec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itpark.larec.entity.ExperimentEntity;

import java.util.List;

@Repository
public interface ExperimentRepository extends JpaRepository<ExperimentEntity, Integer> {
    List<ExperimentEntity> findAllByNameContainsIgnoreCaseOrderByNameDesc(String name);
}
