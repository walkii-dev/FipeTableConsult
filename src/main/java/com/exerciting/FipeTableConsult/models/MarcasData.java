package com.exerciting.FipeTableConsult.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MarcasData(@JsonAlias("codigo")Integer id,
                         @JsonAlias("nome")String marca) {
}
