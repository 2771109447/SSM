package com.smart.service;

import com.smart.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smart.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("bookService")
@Transactional
public class BookService {

    @Autowired
    private BookDao bookDao;
    //获得所有图书信息
    public List<Book> getAllBook(){
        return bookDao.findAllBook();
    }
    //添加图书信息
    public Integer addBook(Book book){
        return bookDao.addBook(book);
    }
}
