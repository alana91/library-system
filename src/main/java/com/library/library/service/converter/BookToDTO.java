package com.library.library.service.converter;

import com.library.library.DTO.BookDTO;
import com.library.library.model.Book;

public final class BookToDTO {

    private static BookToDTO instance = null;

    private BookToDTO(){}

    public static BookToDTO getInstance() {
        if(instance == null) {
            instance = new BookToDTO();
        }
        return instance;
    }

    public BookDTO convert(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setArea(book.getArea());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setCountry(book.getCountry());
        bookDTO.setDate(book.getDate());
        bookDTO.setEdition(book.getEdition());
        bookDTO.setId(book.getId());
        bookDTO.setISBN(book.getISBN());
        bookDTO.setIsBorrowed(book.getBorrowed());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setPublisher(book.getPublisher());
        return bookDTO;
    }
}
