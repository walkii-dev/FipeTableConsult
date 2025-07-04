package com.exerciting.FipeTableConsult.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veichle(@JsonAlias("Valor")String cost,
                      @JsonAlias("Marca")String label,
                      @JsonAlias("Modelo") String model,
                      @JsonAlias("AnoModelo")Integer labelYear,
                      @JsonAlias("Combustivel")String fuel) {
}
