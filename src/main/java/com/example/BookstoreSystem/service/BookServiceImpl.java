package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.dao.BookDao;
import com.example.BookstoreSystem.model.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookService")
public class BookServiceImpl implements BookService {
    final BookDao bookDao;
    public BookServiceImpl(BookDao bookDao) { this.bookDao = bookDao; }

    @Override
    public List<BookDto> selectBookList() { return bookDao.selectBookList(); }

    @Override
    public BookDto selectBookInfo(String bookId) { return bookDao.selectBookInfo(bookId); }
}
