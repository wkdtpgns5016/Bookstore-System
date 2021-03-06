package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.model.BookDto;
import java.util.List;

public interface BookService {
    public List<BookDto> selectBookList();
    public BookDto selectBookInfo(int bookId);
    public int insertBookInfo(BookDto book);
    public int updateBookInfo(BookDto book);
    public int deleteBookInfo(int bookId);
}
