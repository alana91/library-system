package com.library.library.service.converter;

import com.library.library.DTO.PeriodicalDTO;
import com.library.library.model.Periodical;

import java.util.LinkedList;

public final class DTOToPeriodical {
    private static DTOToPeriodical instance = null;

    private DTOToPeriodical(){}

    public static DTOToPeriodical getInstance() {
        if(instance == null) {
            instance = new DTOToPeriodical();
        }
        return instance;
    }

    public Periodical convert(PeriodicalDTO periodicalDTO){
        Periodical periodical = new Periodical();
        periodical.setArea(periodicalDTO.getArea());
        periodical.setAuthor(periodicalDTO.getAuthor());
        periodical.setCountry(periodicalDTO.getCountry());
        periodical.setDate(periodicalDTO.getDate());
        periodical.setId(periodicalDTO.getId());
        periodical.setBorrowed(periodicalDTO.getIsBorrowed());
        periodical.setTitle(periodicalDTO.getTitle());
        periodical.setEdition(periodicalDTO.getEdition());
        periodical.setPublisher(periodicalDTO.getPublisher());
        periodical.setLoansIds(new LinkedList<>());
        return periodical;
    }
}
