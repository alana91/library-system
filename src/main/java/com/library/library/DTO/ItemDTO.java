package com.library.library.DTO;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@name")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AudioDTO.class, name = "AudioDTO"),
        @JsonSubTypes.Type(value = BookDTO.class, name = "BookDTO"),
        @JsonSubTypes.Type(value = PeriodicalDTO.class, name = "PeriodicalDTO"),
        @JsonSubTypes.Type(value = VideoDTO.class, name = "VideoDTO")})

public interface ItemDTO {

    public Date getDate();

    public String getTitle();

    public String getAuthor();

    public String getArea();

    public String getCountry();

    public String getId();

    public Boolean getIsBorrowed();

    public void setDate(Date date);

    public void setTitle(String title);

    public void setAuthor(String authors);

    public void setArea(String area);

    public void setCountry(String country);

    public void setIsBorrowed(Boolean borrowed);

    public void setId(String id);
}
