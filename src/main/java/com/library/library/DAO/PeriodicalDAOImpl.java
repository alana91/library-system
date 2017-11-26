package com.library.library.DAO;

import com.library.library.model.Periodical;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public final class PeriodicalDAOImpl implements PeriodicalDAO {
    private Helper helper = Helper.getInstance();
    private List<Periodical> periodicals = helper.createPeriodicalList();

    private static PeriodicalDAOImpl instance = null;

    public static PeriodicalDAOImpl getInstance() {
        if(instance == null) {
            instance = new PeriodicalDAOImpl();
        }
        return instance;
    }
    
    @Override
    public List<Periodical> getAll(){
        return periodicals;
    }

    @Override
    public Periodical getPeriodical(String id){
        Periodical selectedPeriodical = null;
        for(Periodical periodical : periodicals){
            if(periodical.getId().equals(id)){
                selectedPeriodical = periodical;
                break;
            }
        }
        return selectedPeriodical;
    }

    @Override
    public Periodical addPeriodical(Periodical periodical){
        periodicals.add(periodical);
        return periodical;
    }

    @Override
    public Periodical updatePeriodical(Periodical periodical, String id){
        Periodical selectedPeriodical = getPeriodical(id);
        selectedPeriodical.setArea(periodical.getArea());
        selectedPeriodical.setAuthor(periodical.getAuthor());
        selectedPeriodical.setCountry(periodical.getCountry());
        selectedPeriodical.setDate(periodical.getDate());
        selectedPeriodical.setTitle(periodical.getTitle());
        selectedPeriodical.setBorrowed(periodical.getBorrowed());
        selectedPeriodical.setPublisher(periodical.getPublisher());
        selectedPeriodical.setEdition(periodical.getEdition());
        return selectedPeriodical;
    }
}
