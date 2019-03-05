package ru.itpark.larec.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.itpark.larec.entity.ExperimentEntity;
import ru.itpark.larec.entity.ProductEntity;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ExperimentRepository experimentRepository;

    @Autowired
    private EntityManager em;
    @BeforeEach
    void setUp() {
        ProductEntity productEntity = new ProductEntity(
                1,
                experimentRepository.save(new ExperimentEntity(
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
                        null)),
                null,
                null,
                null,
                null,
                null);
        em.merge(productEntity);
    }

    @Test
    public void add() {
        ProductEntity productTwoEntity = new ProductEntity(
                2,
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
                        null)),
                null,
                null,
                null,
                null,
                null);

        repository.save(productTwoEntity);
        assertEquals(2, repository.findAll().size());
    }

    @Test
    public void findAll() {
        var actual = repository.findAll().size();
        assertEquals(1, actual);
    }
}