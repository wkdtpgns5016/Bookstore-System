package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.model.BookDto;
import java.util.List;

public interface BookService {
    public List<BookDto> selectBookList();
    public BookDto selectBookInfo(String bookId);
}
