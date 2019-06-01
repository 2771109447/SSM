package com.smart.dao;

import com.smart.domain.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAllBook();
    Integer  addBook(Book book);
}
