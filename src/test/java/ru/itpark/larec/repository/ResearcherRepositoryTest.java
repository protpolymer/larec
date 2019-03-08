package ru.itpark.larec.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.itpark.larec.entity.ExperimentEntity;
import ru.itpark.larec.entity.ResearcherEntity;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ResearcherRepositoryTest {
    @Autowired
    private ResearcherRepository repository;

    @Autowired
    private ExperimentRepository experimentRepository;

    @Autowired
    private EntityManager em;
    @BeforeEach
    void setUp() {
        ResearcherEntity researcherEntity = new ResearcherEntity(
                1,
                experimentRepository.save(
                        new ExperimentEntity(
                                2,
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
                        )),
                null,
                12
        );
        em.merge(researcherEntity);
    }

    @Test
    public void add() {
        ResearcherEntity researcherTwoEntity = new ResearcherEntity(
                5,
                experimentRepository.save(
                        new ExperimentEntity(
                                4,
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
                        )),
                null,
                12
        );
        repository.save(researcherTwoEntity);
        assertEquals(2, repository.findAll().size());
    }

    @Test
    public  void findAll() {
        assertEquals(1, repository.findAll().size());
    }

}