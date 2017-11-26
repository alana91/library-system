package com.library.library.service.converter;

import com.library.library.DTO.AudioDTO;
import com.library.library.model.Audio;

public final class AudioToDTO {

    private static AudioToDTO instance = null;

    private AudioToDTO(){}

    public static AudioToDTO getInstance() {
        if(instance == null) {
            instance = new AudioToDTO();
        }
        return instance;
    }

    public AudioDTO convert(Audio audio){
        AudioDTO audioDTO = new AudioDTO();
        audioDTO.setArea(audio.getArea());
        audioDTO.setAuthor(audio.getAuthor());
        audioDTO.setCountry(audio.getCountry());
        audioDTO.setDate(audio.getDate());
        audioDTO.setId(audio.getId());
        audioDTO.setIsBorrowed(audio.getBorrowed());
        audioDTO.setTitle(audio.getTitle());
        audioDTO.setRecordCompanies(audio.getRecordCompany());
        return audioDTO;
    }
}
