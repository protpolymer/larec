package ru.itpark.larec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperimentDto {
    private int id;
    private String reaction;
    private String name;
    private String date;
    private String processConditions;
    private String description;
    private String conclusion;
    private String linkOfDocumentationExperiment;
}
