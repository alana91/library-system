package com.library.library.service.converter;

import com.library.library.DTO.AudioDTO;
import com.library.library.model.Audio;

import java.util.LinkedList;

public final class DTOToAudio {

    private static DTOToAudio instance = null;

    private DTOToAudio(){}

    public static DTOToAudio getInstance() {
        if(instance == null) {
            instance = new DTOToAudio();
        }
        return instance;
    }

    public Audio convert(AudioDTO audioDTO){
        Audio audio = new Audio();
        audio.setArea(audioDTO.getArea());
        audio.setAuthor(audioDTO.getAuthor());
        audio.setCountry(audioDTO.getCountry());
        audio.setDate(audioDTO.getDate());
        audio.setId(audioDTO.getId());
        audio.setBorrowed(audioDTO.getIsBorrowed());
        audio.setTitle(audioDTO.getTitle());
        audio.setRecordCompany(audioDTO.getRecordCompanies());
        audio.setLoansIds(new LinkedList<>());
        return audio;
    }
}
