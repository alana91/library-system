package com.library.library.DAO;

import com.library.library.model.Book;

import java.util.List;

public interface BookDAO {

    List<Book> getAll();

    Book getBook(String id);

    Book addBook(Book item);

    Book updateBook(Book item, String id);
}
