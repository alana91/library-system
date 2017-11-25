// codebeat:disable[TOO_MANY_IVARS, ABC, TOTAL_COMPLEXITY]

package com.library.library.DAO;

import com.library.library.DTO.*;
import com.library.library.model.User;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public final class Helper {
    /**
     * This class will be used to create objects to be returned as we're not connecting to a real database
     */

    private static Helper instance = null;

    public Helper(){}

    static Helper getInstance() {
        if(instance == null) {
            instance = new Helper();
        }
        return instance;
    }

    private static Date date = new Date();
    private static Date dueDate = new Date();
    private static List items;
    private static List users;
    private static List loans;

    private void passTime(){
        dueDate.setTime(date.getTime() + 1296000000);
    }



    protected List<ItemDTO> createItemList(){
        if(items==null){
            items = new LinkedList<ItemDTO>();
            items.add(new BookDTO(date, "BookDTO Title", "Author", "Neuroscience", "Argentina",
                    "ISBN", "Publisher", 3, true, "1"));
            items.add(new BookDTO(date, "BookDTO Title 2", "Author", "Computer Science", "Brazil",
                    "ISBN", "Publisher", 3, true, "2"));
            items.add(new AudioDTO(date, "AudioDTO Title", "Singer", "Rock", "Japan",
                    "Record Company", true, "3"));
            items.add(new AudioDTO(date, "AudioDTO Title 2", "Band", "Country", "USA",
                    "Record Company", false,"4"));
            items.add(new PeriodicalDTO(date, "Magazine Title", null, "Gossip", "England",
                    "Publisher", 22, false,"5"));
            items.add(new PeriodicalDTO(date, "Magazine Title", null, "Microbiology", "France",
                    "Publisher", 1, false,"6"));
            items.add(new VideoDTO(date, "VideoDTO Title", "Director", "Documentary","Denmark",
                    false,"7"));
            items.add(new VideoDTO(date, "VideoDTO Title 2", "Director", "Horror","South Korea",
                    false,"8"));
        }
        return items;
    }

    protected List<User> createUserList(){
        if(users==null){
            users = new LinkedList<User>();
            users.add(new User("John", false, "client","1"));
            users.add(new User("Mary", false, "clerk","2"));
            users.add(new User("Elliot", false, "clerk","3"));
            users.add(new User("Mary", false, "client","4"));
            users.add(new User("Melissa", false, "clerk","5"));
            users.add(new User("Edward", false, "client","6"));
        }
        return users;
    }

    protected List<LoanDTO> createLoanList(){
        if(loans==null){
            passTime();
            users = createUserList();
            items = createItemList();
            loans = new LinkedList<LoanDTO>();
            loans.add(new LoanDTO((User)users.get(0), (User)users.get(1), date, dueDate,
                    new LinkedList<>(Arrays.asList((ItemDTO)items.get(0))), false, "1"));
            loans.add(new LoanDTO((User)users.get(3), (User)users.get(2), date, dueDate,
                    new LinkedList<>(Arrays.asList((ItemDTO)items.get(1), (ItemDTO)items.get(2))),false, "2"));
        }
        return loans;
    }

}

// codebeat:enable[TOO_MANY_IVARS, ABC, TOTAL_COMPLEXITY]
