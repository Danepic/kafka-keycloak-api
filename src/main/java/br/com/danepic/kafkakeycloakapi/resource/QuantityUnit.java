package br.com.danepic.kafkakeycloakapi.resource;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class QuantityUnit {
    private BigDecimal value;
    private String unit;
}
