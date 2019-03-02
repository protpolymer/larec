package ru.itpark.larec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int experimentId;
    private String name;
    private BigDecimal molecularWeight;
    private String formula;
    private String linkForDescription;
    private BigDecimal amountGram;
}
