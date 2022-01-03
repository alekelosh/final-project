package com.aacademy.Finalproject.service.impl;

import com.aacademy.Finalproject.entity.Book;
import com.aacademy.Finalproject.repository.BookRepository;
import com.aacademy.Finalproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository ;
    }
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Book not found with id:"+id));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
