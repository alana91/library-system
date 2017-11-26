package com.library.library.DAO;

import com.library.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public final class BookDAOImpl implements BookDAO{

    private Helper helper = Helper.getInstance();
    private List<Book> books = helper.createBookList();

    private static BookDAOImpl instance = null;

    public static BookDAOImpl getInstance() {
        if(instance == null) {
            instance = new BookDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Book> getAll(){
        return books;
    }

    @Override
    public Book getBook(String id){
        Book selectedBook = null;
        for(Book book : books){
            if(book.getId().equals(id)){
                selectedBook = book;
                break;
            }
        }
        return selectedBook;
    }

    @Override
    public Book addBook(Book book){
        books.add(book);
        return book;
    }

    @Override
    public Book updateBook(Book book, String id){
        Book selectedBook = getBook(id);
        selectedBook.setArea(book.getArea());
        selectedBook.setAuthor(book.getAuthor());
        selectedBook.setCountry(book.getCountry());
        selectedBook.setDate(book.getDate());
        selectedBook.setTitle(book.getTitle());
        selectedBook.setBorrowed(book.getBorrowed());
        selectedBook.setPublisher(book.getPublisher());
        selectedBook.setISBN(book.getISBN());
        selectedBook.setEdition(book.getEdition());
        return selectedBook;
    }
}
