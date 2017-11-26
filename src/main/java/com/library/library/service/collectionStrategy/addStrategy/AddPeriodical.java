package com.library.library.service.collectionStrategy.addStrategy;

import com.library.library.DAO.PeriodicalDAOImpl;
import com.library.library.DTO.PeriodicalDTO;
import com.library.library.model.Periodical;
import com.library.library.service.converter.DTOToPeriodical;
import com.library.library.service.converter.PeriodicalToDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class AddPeriodical implements AddStrategy {

    private DTOToPeriodical dtoToPeriodical = DTOToPeriodical.getInstance();
    private PeriodicalToDTO periodicalToDTO = PeriodicalToDTO.getInstance();
    private PeriodicalDAOImpl periodicalDAO = PeriodicalDAOImpl.getInstance();

    @Override
    public Object addItem(Object object) {
        Periodical periodical = dtoToPeriodical.convert((PeriodicalDTO)object);
        return periodicalToDTO.convert(periodicalDAO.addPeriodical(periodical));
    }
}
