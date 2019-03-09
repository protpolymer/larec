package ru.itpark.larec.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.itpark.larec.entity.ExperimentEntity;
import ru.itpark.larec.entity.ReagentEntity;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ReagentRepositoryTest {

    @Autowired
    private ReagentRepository repository;

    @Autowired
    private ExperimentRepository experimentRepository;

    @Autowired
    private EntityManager em;
    @BeforeEach
    void setUp() {
        ReagentEntity reagentEntity = new ReagentEntity(
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
                0.0,
                null,
                null,
                0.0
        );
        em.merge(reagentEntity);
    }

    @Test
    public void add() {
        ReagentEntity reagentTwoEntity = new ReagentEntity(
                2,
                experimentRepository.save(
                        new ExperimentEntity(
                                3,
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
                0.0,
                null,
                null,
                0.0
        );
        repository.save(reagentTwoEntity);
        assertEquals(2, repository.findAll().size());
    }

    @Test
    public void findAll() {
        var actual = repository.findAll().size();
        assertEquals(1, actual);
    }

}