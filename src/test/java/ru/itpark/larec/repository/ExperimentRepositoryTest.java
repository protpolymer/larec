package ru.itpark.larec.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.itpark.larec.entity.ExperimentEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ExperimentRepositoryTest {
    @Autowired
    private ExperimentRepository repository;

    @Autowired
    private TestEntityManager em;

    @BeforeEach
    void setUp() {
        ExperimentEntity experimentEntity = new ExperimentEntity
                (
                        1,
                        "reaction",
                        "name",
                        "date",
                        null,
                        null,
                        "qw",
                        "qw",
                        null,
                        null,
                        "qw",
                        "qw"
                );
        em.merge(experimentEntity);
    }

    @Test
    void findAll() {
        var actual = repository.findAll().size();
        assertEquals(1, actual);
    }

    @Test
    void add() {
        repository.save(
                new ExperimentEntity(
                        3,
                        "reaction3",
                        "name3",
                        "date3",
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                ));
        assertEquals(2, repository.findAll().size());
    }

    @Test
    void findByName() {
        repository.save(
                new ExperimentEntity(
                        3,
                        "reaction3",
                        "experiment",
                        "date3",
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                ));
        var actual = repository
                .findAllByNameContainsIgnoreCaseOrderByNameDesc("experiment")
                .size();

        assertEquals(1, actual);
    }

}