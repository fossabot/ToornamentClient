package com.toornament.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Round {
    private String id;
    private String stage_id;
    private String group_id;
    private Integer number;
    private String name;
    private Boolean closed;
    private Settings settings;

    @Setter
    @Getter
    private class Settings{
        String size;
        public Settings(){}

    }
    @Override
    public String toString() {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
