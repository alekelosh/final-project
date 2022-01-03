package com.aacademy.Finalproject.runner;

import com.aacademy.Finalproject.entity.Book;
import com.aacademy.Finalproject.entity.Writer;
import com.aacademy.Finalproject.service.BookService;
import com.aacademy.Finalproject.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private final BookService bookService;
    private final WriterService writerService;

    @Autowired
    public ApplicationRunner(BookService bookService, WriterService writerService)
    {
        this.bookService=bookService;
        this.writerService=writerService;
    }
    @Override
    public void run(String... args) throws Exception {
        Book book= Book.builder()
                .name("Sound of Terror")
                .releaseDate(LocalDate.now())
                .build();
        Book savedBook = bookService.save(book);
        Writer writer=Writer.builder()
                .age(30)
                .name("Tery Plock")
                .books(Set.of(savedBook))
                .dateBirth(LocalDate.now())
                .build();
        Writer savedWriter = writerService.save(writer);
        Writer foundWriter = writerService.findById(savedWriter.getId());
        Book foundBook = bookService.findById(savedBook.getId());
        Set<Book> books = foundWriter.getBooks();
        System.out.println(5);

    }
}
