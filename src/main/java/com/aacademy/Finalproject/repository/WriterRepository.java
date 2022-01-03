package com.aacademy.Finalproject.repository;

import com.aacademy.Finalproject.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterRepository extends JpaRepository<Writer,Long> {
}
