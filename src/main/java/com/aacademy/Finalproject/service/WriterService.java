package com.aacademy.Finalproject.service;

import com.aacademy.Finalproject.entity.Writer;

import java.util.List;

public interface WriterService {

    List<Writer> findAll();
    Writer save(Writer writer);

    Writer findById(Long id);
}
