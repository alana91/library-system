package com.library.library.service.collectionStrategy.updateStrategy;

import com.library.library.DAO.BookDAOImpl;
import com.library.library.DTO.BookDTO;
import com.library.library.model.Book;
import com.library.library.service.converter.BookToDTO;
import com.library.library.service.converter.DTOToBook;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateBook implements UpdateStrategy {

    private BookToDTO bookToDTO = BookToDTO.getInstance();
    private BookDAOImpl bookDAO = BookDAOImpl.getInstance();
    private DTOToBook dtoToBook = DTOToBook.getInstance();

    @Override
    public Object updateItem(Object object, String id){
        BookDTO bookDTO = (BookDTO) object;
        Book book = dtoToBook.convert(bookDTO);

        return bookToDTO.convert(bookDAO.updateBook(book, id));
    }
}
