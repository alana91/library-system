// codebeat:disable[TOO_MANY_IVARS, ABC, TOTAL_COMPLEXITY]

package com.library.library.DAO;

import com.library.library.model.*;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

final class Helper {
    /**
     * This class will be used to create objects to be returned as we're not connecting to a real database
     */

    private static Helper instance = null;

    private Helper(){}

    static Helper getInstance() {
        if(instance == null) {
            instance = new Helper();
        }
        return instance;
    }

    private static Date date = new Date();
    private static Date dueDate = new Date();
    private static List users;
    private static List loans;
    private static List loans_items;
    private static List books;
    private static List audios;
    private static List periodicals;
    private static List videos;

    private void passTime(){
        dueDate.setTime(date.getTime() + 1296000000);
    }

    List<Book> createBookList(){
        if(books==null) {
            books = new LinkedList<Book>();
            books.add(new Book(date, "Book Title", "Author", "Neuroscience", "Argentina",
                    "ISBN", "Publisher", 3, true, "1",
                    new LinkedList<>(Arrays.asList("1"))));
            books.add(new Book(date, "Book Title 2", "Author", "Computer Science", "Brazil",
                    "ISBN", "Publisher", 3, true, "2",
                    new LinkedList<>(Arrays.asList("1"))));
        }
        return books;
    }

    List<Audio> createAudioList(){
        if(audios==null) {
            audios = new LinkedList<Audio>();
            audios.add(new Audio(date, "Audio Title", "Singer", "Rock", "Japan",
                    "Record Company", true, "3",  new LinkedList<>(Arrays.asList("2"))));
            audios.add(new Audio(date, "Audio Title 2", "Band", "Country", "USA",
                    "Record Company", false,"4", new LinkedList<>()));
        }
        return audios;
    }

    List<Periodical> createPeriodicalList(){
        if(periodicals==null) {
            periodicals = new LinkedList<Periodical>();
            periodicals.add(new Periodical(date, "Magazine Title", null, "Gossip", "England",
                    "Publisher", 22, false,"5", new LinkedList<>()));
            periodicals.add(new Periodical(date, "Magazine Title", null, "Microbiology", "France",
                    "Publisher", 1, false,"6", new LinkedList<>()));
        }
        return periodicals;
    }

    List<Video> createVideoList(){
        if(videos==null) {
            videos = new LinkedList<Video>();
            videos.add(new Video(date, "VideoDTO Title", "Director", "Documentary","Denmark",
                    false,"7", new LinkedList<>()));
            videos.add(new Video(date, "VideoDTO Title 2", "Director", "Horror","South Korea",
                    false,"8", new LinkedList<>()));
        }
        return videos;
    }

    List<User> createUserList(){
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

    List<Loan> createLoanList(){
        if(loans==null){
            passTime();
            users = createUserList();
            books = createBookList();
            audios = createAudioList();
            loans = new LinkedList<Loan>();
            loans.add(new Loan("1", "2", date, dueDate,
                    new LinkedList<>(Arrays.asList("1")), false, "1"));
            loans.add(new Loan("4", "5", date, dueDate,
                    new LinkedList<>(Arrays.asList("2", "3")),false, "2"));
        }
        return loans;
    }

    List<Loan_Item> createLoan_ItemList(){
        if(loans_items==null) {
            loans_items = new LinkedList<Loan_Item>();
            loans_items.add(new Loan_Item(1L, "1", "1"));
            loans_items.add(new Loan_Item(2L, "2", "2"));
            loans_items.add(new Loan_Item(3L, "3", "2"));
        }
        return loans_items;
    }

}

// codebeat:enable[TOO_MANY_IVARS, ABC, TOTAL_COMPLEXITY]
