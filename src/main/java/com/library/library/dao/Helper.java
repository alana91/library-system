package com.library.library.dao;

import com.library.library.model.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Helper {
    /**
     * This class will be used to create objects to be returned as we're not connecting to a real database
     */

    public Helper(){}

    private Date date = new Date();
    private Date dueDate = new Date();
    private List items;
    private List authors;
    private List publishers;
    private List recordCompanies;
    private List directors;
    private List users;
    private List loans;

    private void passTime(){
        dueDate.setTime(date.getTime() + 1296000000);
    }

    protected List<Item> createItemList(){
        if(items==null){
            items = new LinkedList<Item>();
            items.add(new Book(date, "Book Title", createAuthorList(), "Neuroscience", "Argentina",
                    "ISBN", createPublisher(), 3));
            items.add(new Book(date, "Book Title 2", createAuthorList(), "Computer Science", "Brazil",
                    "ISBN", createPublisher(), 3));
            items.add(new Audio(date, "Audio Title", createAuthorList(), "Rock", "Japan",
                    createRecordCompany()));
            items.add(new Audio(date, "Audio Title 2", createAuthorList(), "Country", "USA",
                    createRecordCompany()));
            items.add(new Periodical(date, "Magazine Title", null, "Gossip", "England",
                    createPublisher(), 22));
            items.add(new Periodical(date, "Magazine Title", null, "Microbiology", "France",
                    createPublisher(), 1));
            items.add(new Video(date, "Video Title", createDirectorList(), "Documentary","Denmark"));
            items.add(new Video(date, "Video Title 2", createDirectorList(), "Horror","South Korea"));
        }
        return items;
    }

    protected List<User> createUserList(){
        if(users==null){
            users = new LinkedList<User>();
            users.add(new User("John", false, "client"));
            users.add(new User("Mary", false, "clerk"));
            users.add(new User("Elliot", false, "clerk"));
            users.add(new User("Mary", false, "client"));
            users.add(new User("Melissa", false, "clerk"));
            users.add(new User("Edward", false, "client"));
        }
        return users;
    }

    protected List<Loan> createLoanList(){
        if(loans==null){
            passTime();
            users = createUserList();
            items = createItemList();
            loans = new LinkedList<Loan>();
            loans.add(new Loan((User)users.get(0), (User)users.get(1), date, dueDate, items));
            loans.add(new Loan((User)users.get(3), (User)users.get(2), date, dueDate, items));
        }
        return loans;
    }

    private List<PersonOrCompany> createAuthorList(){
        if(authors==null){
            authors = new LinkedList<PersonOrCompany>();
            authors.add(new PersonOrCompany("Author 1"));
            authors.add(new PersonOrCompany("Author 2"));
        }
        return authors;
    }

    private List<PersonOrCompany> createDirectorList(){
        if(directors==null){
            directors = new LinkedList<PersonOrCompany>();
            directors.add(new PersonOrCompany("Director 1"));
            directors.add(new PersonOrCompany("Director 2"));
        }
        return directors;
    }

    private List<PersonOrCompany> createPublisher(){
        if(publishers==null){
            publishers = new LinkedList<PersonOrCompany>();
            publishers.add(new PersonOrCompany("Publisher"));
        }
        return publishers;
    }

    private List<PersonOrCompany> createRecordCompany(){
        if(recordCompanies==null){
            recordCompanies = new LinkedList<PersonOrCompany>();
            recordCompanies.add(new PersonOrCompany("Record Company"));
        }
        return recordCompanies;
    }
}
