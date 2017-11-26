package com.library.library.service.converter;

import com.library.library.DTO.PeriodicalDTO;
import com.library.library.model.Periodical;

public final class PeriodicalToDTO {
    private static PeriodicalToDTO instance = null;

    private PeriodicalToDTO(){}

    public static PeriodicalToDTO getInstance() {
        if(instance == null) {
            instance = new PeriodicalToDTO();
        }
        return instance;
    }

    public PeriodicalDTO convert(Periodical periodical){
        PeriodicalDTO periodicalDTO = new PeriodicalDTO();
        periodicalDTO.setArea(periodical.getArea());
        periodicalDTO.setAuthor(periodical.getAuthor());
        periodicalDTO.setCountry(periodical.getCountry());
        periodicalDTO.setDate(periodical.getDate());
        periodicalDTO.setEdition(periodical.getEdition());
        periodicalDTO.setId(periodical.getId());
        periodicalDTO.setIsBorrowed(periodical.getBorrowed());
        periodicalDTO.setTitle(periodical.getTitle());
        periodicalDTO.setPublisher(periodical.getPublisher());
        return periodicalDTO;
    }
}
