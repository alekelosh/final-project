package com.aacademy.Finalproject.service;

import com.aacademy.Finalproject.entity.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    Book findById(Long id);

    List<Book> findAll();

}
