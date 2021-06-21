package com.example.BookstoreSystem.controller;

import com.example.BookstoreSystem.model.BookDto;
import com.example.BookstoreSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public int insertBookInfo(@RequestBody BookDto book){ return bookService.insertBookInfo(book); }
}
