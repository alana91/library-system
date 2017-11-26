package com.library.library.service.collectionStrategy.updateStrategy;

import com.library.library.DAO.PeriodicalDAOImpl;
import com.library.library.DTO.PeriodicalDTO;
import com.library.library.model.Periodical;
import com.library.library.service.converter.DTOToPeriodical;
import com.library.library.service.converter.PeriodicalToDTO;

public class UpdatePeriodical implements UpdateStrategy{

    private PeriodicalToDTO periodicalToDTO = PeriodicalToDTO.getInstance();
    private PeriodicalDAOImpl periodicalDAO = PeriodicalDAOImpl.getInstance();
    private DTOToPeriodical dtoToPeriodical = DTOToPeriodical.getInstance();

    @Override
    public Object updateItem(Object object, String id){
        PeriodicalDTO periodicalDTO = (PeriodicalDTO) object;
        Periodical periodical = dtoToPeriodical.convert(periodicalDTO);

        return periodicalToDTO.convert(periodicalDAO.updatePeriodical(periodical, id));
    }
}
