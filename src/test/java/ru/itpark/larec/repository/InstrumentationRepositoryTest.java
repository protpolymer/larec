package ru.itpark.larec.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.itpark.larec.entity.ExperimentEntity;
import ru.itpark.larec.entity.InstrumentationEntity;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class InstrumentationRepositoryTest {
    @Autowired
    private InstrumentationRepository repository;
    @Autowired
    private ExperimentRepository experimentRepository;

    @Autowired
    private EntityManager em;

    @BeforeEach
    void setUp() {
        InstrumentationEntity instrumentationEntity = new InstrumentationEntity(
                1,
                "instrumentation",
                experimentRepository.save(new ExperimentEntity(
                    1,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
        )));
        em.merge(instrumentationEntity);
    }

    @Test
    public void add() {
        InstrumentationEntity instrumentationEntity = new InstrumentationEntity(
                2,
                "instrumentationTwo",
                experimentRepository.save(new ExperimentEntity(
                                1,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                )));
        repository.save(instrumentationEntity);
        assertEquals(2, repository.findAll().size());
    }

    @Test void findAll() {
        var actual = repository.findAll().size();
        assertEquals(1, actual);
    }
}