package ru.itpark.larec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.larec.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
