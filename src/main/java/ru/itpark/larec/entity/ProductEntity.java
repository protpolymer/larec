package ru.itpark.larec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private ExperimentEntity experiment;

    private String name;
    private BigDecimal molecularWeight;
    private String formula;
    private String linkForDescription;
    private BigDecimal amountGram;
}