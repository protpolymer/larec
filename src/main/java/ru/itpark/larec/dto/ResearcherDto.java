package ru.itpark.larec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResearcherDto {

    private int id;
    private int experimentId;
    private String name;
    private int age;
}
