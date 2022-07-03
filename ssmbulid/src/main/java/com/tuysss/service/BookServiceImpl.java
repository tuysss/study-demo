package com.tuysss.service;

import com.tuysss.dao.BookMapper;
import com.tuysss.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
    核心逻辑：Service层调用Dao层 -> 组合Dao层  -> setter方法，由spring托管
 */
//@Service
public class BookServiceImpl implements BookService{
    private BookMapper bookMapper;

    //@Autowired
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public List<Books> queryBooksByName(String bookName) {
        return bookMapper.queryBooksByName(bookName);
    }
}
