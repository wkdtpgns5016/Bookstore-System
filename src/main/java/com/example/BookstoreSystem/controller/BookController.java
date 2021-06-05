package com.example.BookstoreSystem.controller;

import com.example.BookstoreSystem.model.BookDto;
import com.example.BookstoreSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) { this.bookService = bookService; }

    @GetMapping("")
    public List<BookDto> selectBookList(){ return bookService.selectBookList(); }

    @GetMapping("/{bookId}")
    public BookDto selectBookInfo(@PathVariable String bookId){ return bookService.selectBookInfo(bookId); }
}
