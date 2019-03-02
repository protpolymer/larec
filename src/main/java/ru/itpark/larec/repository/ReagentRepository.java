package ru.itpark.larec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.larec.entity.ReagentEntity;

import java.util.List;

public interface ReagentRepository extends JpaRepository<ReagentEntity, Integer> {
    List<ReagentEntity> findAllByExperimentId(int id);
}
