package ru.itpark.larec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExperimentEntity {
    @Id
    @GeneratedValue
    private int id;

    private String reaction;
    private String name;
    private String date;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ReagentEntity> reagents;

    @OneToMany(cascade = CascadeType.ALL)
    private List<InstrumentationEntity> instrumentations;

    private String processConditions;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ResearcherEntity> researchers;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductEntity> products;
    private String conclusion;
    private String linkOfDocumentationExperiment;
}