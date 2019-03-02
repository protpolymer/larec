package ru.itpark.larec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.larec.entity.InstrumentationEntity;

public interface InstrumentationRepository extends JpaRepository<InstrumentationEntity, Integer> {
}
