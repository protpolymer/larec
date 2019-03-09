package ru.itpark.larec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReagentEntity {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ExperimentEntity experiment;

    private String name;
    private double molecularWeight;
    private String formula;
    private String linkForDescription;
    private double amountGram;
}
