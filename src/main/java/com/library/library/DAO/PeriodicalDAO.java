package com.library.library.DAO;

import com.library.library.model.Periodical;

import java.util.List;

public interface PeriodicalDAO {

    List<Periodical> getAll();

    Periodical getPeriodical(String id);

    Periodical addPeriodical(Periodical item);

    Periodical updatePeriodical(Periodical item, String id);
}
