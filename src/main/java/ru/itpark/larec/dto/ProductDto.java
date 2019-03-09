package ru.itpark.larec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int experimentId;
    private String name;
    private double molecularWeight;
    private String formula;
    private String linkForDescription;
    private double amountGram;
}
