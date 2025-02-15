package com.toornament.model;

import com.toornament.model.enums.TournamentStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.TimeZone;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public class Tournament {

    private String id;
    private String discipline;
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    private LocalDate scheduled_date_start;
    private LocalDate scheduled_date_end;
    private TournamentStatus status;
    @JsonProperty("date_start")
    private LocalDate dateStart;
    @JsonProperty("date_end")
    private LocalDate dateEnd;
    private Boolean online;
    @JsonProperty("public")
    private Boolean isPublic;
    private Boolean archived;
    private String location;
    private String country;
    private Integer size;
    private Logo logo;
    private ArrayList<String> platforms;
    private String registration_enabled;
    private ZonedDateTime registration_opening_datetime;
    private ZonedDateTime registration_closing_datetime;
    @JsonProperty("public")
    private boolean public_event;
    private TimeZone timezone;

    public Tournament() {
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writer(new SimpleDateFormat("yyyy-mm-dd")).withDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
