package com.aacademy.Finalproject.service.impl;

import com.aacademy.Finalproject.entity.Book;
import com.aacademy.Finalproject.entity.Writer;
import com.aacademy.Finalproject.repository.WriterRepository;
import com.aacademy.Finalproject.service.BookService;
import com.aacademy.Finalproject.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class WriterServiceimpl implements WriterService {

    private final WriterRepository writerRepository;
    private final BookService bookService;
    @Autowired
    public WriterServiceimpl(WriterRepository writerRepository, BookService bookService){
        this.writerRepository= writerRepository;
        this.bookService = bookService;
    }

    @Override
    public List<Writer> findAll() {
        return writerRepository.findAll();
    }

    @Override
    public Writer save(Writer writer) {
        Book book =bookService.findById(1L);
        Writer newriter=Writer.builder()
                .name(writer.getName())
                .books(Set.of(book))
                .build();
        return writerRepository.save(newriter);
    }

    @Override
    public Writer findById(Long id) {
        return writerRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Writer not found with id:"+id));
    }
}
