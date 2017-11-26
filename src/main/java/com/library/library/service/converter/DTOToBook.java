package com.library.library.service.converter;

import com.library.library.DTO.BookDTO;
import com.library.library.model.Book;

import java.util.LinkedList;

public final class DTOToBook {
    private static DTOToBook instance = null;

    private DTOToBook(){}

    public static DTOToBook getInstance() {
        if(instance == null) {
            instance = new DTOToBook();
        }
        return instance;
    }

    public Book convert(BookDTO bookDTO){
        Book book = new Book();
        book.setArea(bookDTO.getArea());
        book.setAuthor(bookDTO.getAuthor());
        book.setCountry(bookDTO.getCountry());
        book.setDate(bookDTO.getDate());
        book.setId(bookDTO.getId());
        book.setBorrowed(bookDTO.getIsBorrowed());
        book.setTitle(bookDTO.getTitle());
        book.setEdition(bookDTO.getEdition());
        book.setISBN(bookDTO.getISBN());
        book.setPublisher(bookDTO.getPublisher());
        book.setLoansIds(new LinkedList<>());
        return book;
    }
}
