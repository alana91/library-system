package com.library.library.dao;

import com.library.library.model.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Helper {
    /**
     * This class will be used to create objects to be returned as we're not connecting to a real database
     */

    public Helper(){}

    private static Date date = new Date();
    private List items;
    private List authors;
    private List publishers;
    private List recordCompanies;
    private List directors;

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
