package com.exerciting.FipeTableConsult.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IdentifyData(@JsonAlias("codigo")String id,
                           @JsonAlias("nome")String marca) {
}
