package com.toornament.model.request;

import com.toornament.model.enums.MatchFormat;
import com.toornament.model.enums.ParticipantType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TournamentRequest {

    private String discipline;
    private String name;
    private Integer size;
    @JsonProperty("participant_type")
    private ParticipantType participantType;
    @JsonProperty("full_name")
    private String fullName;
    private String organization;
    private String website;
    @JsonProperty("scheduled_date_start")
    private LocalDate dateStart;
    @JsonProperty("scheduled_date_end")
    private LocalDate dateEnd;
    private String timezone;
    private Boolean online;
    @JsonProperty("public")
    private Boolean isPublic;
    private String location;
    private String country;
    private String description;
    private String rules;
    private String prize;
    @JsonProperty("check_in")
    private Boolean checkIn;
    @JsonProperty("participant_nationality")
    private Boolean participantNationality;
    @JsonProperty("match_format")
    private MatchFormat matchFormat;
    private Boolean archived;
    private Boolean match_report_enabled;
    private Boolean registration_enabled;
    private LocalDateTime registration_opening_datetime;
    private LocalDateTime registration_closing_datetime;
    private Boolean registration_notification_enabled;
    private String registration_request_message;
    private String registration_accept_message;
    private String registration_refuse_message;
    private Boolean check_in_enabled;
    private Boolean check_in_participant_enabled;
    private LocalDateTime check_in_participant_start_datetime;
    private LocalDateTime check_in_participant_end_datetime;

    public TournamentRequest() {
    }

    public TournamentRequest(String discipline, String name, Integer size, ParticipantType participantType) {
        this(discipline, name, size, participantType, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public TournamentRequest(String discipline, String name, Integer size, ParticipantType participantType, String fullName, String organization, String website, LocalDate dateStart, LocalDate dateEnd, String timezone, Boolean online, Boolean isPublic, String location, String country, String description, String rules, String prize, Boolean checkIn, Boolean participantNationality, MatchFormat matchFormat) {
        this.discipline = discipline;
        this.name = name;
        this.size = size;
        this.participantType = participantType;
        this.fullName = fullName;
        this.organization = organization;
        this.website = website;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.timezone = timezone;
        this.online = online;
        this.isPublic = isPublic;
        this.location = location;
        this.country = country;
        this.description = description;
        this.rules = rules;
        this.prize = prize;
        this.checkIn = checkIn;
        this.participantNationality = participantNationality;
        this.matchFormat = matchFormat;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writer(new SimpleDateFormat("yyyy-mm-dd")).writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
