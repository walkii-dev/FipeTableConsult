package com.exerciting.FipeTableConsult.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConvertData implements ConvertDataInterface{
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <G> G converter (String json, Class<G> type){
        try{
            return mapper.readValue(json,type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public <G> List<G> convertToList(String json, Class<G> type) {
        CollectionType list = mapper.getTypeFactory().constructCollectionType(List.class,type);
        try {
            return mapper.readValue(json,list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
