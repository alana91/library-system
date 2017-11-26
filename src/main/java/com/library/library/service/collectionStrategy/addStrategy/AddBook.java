package com.library.library.service.collectionStrategy.addStrategy;

import com.library.library.DAO.BookDAOImpl;
import com.library.library.DTO.BookDTO;
import com.library.library.model.Book;
import com.library.library.service.converter.BookToDTO;
import com.library.library.service.converter.DTOToBook;

public class AddBook implements AddStrategy {

    private DTOToBook dtoToBook = DTOToBook.getInstance();
    private BookToDTO bookToDTO = BookToDTO.getInstance();
    private BookDAOImpl bookDAO = BookDAOImpl.getInstance();

    @Override
    public Object addItem(Object object) {
        Book book = dtoToBook.convert((BookDTO)object);
        return bookToDTO.convert(bookDAO.addBook(book));
    }
}

