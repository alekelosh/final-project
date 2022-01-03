package com.aacademy.Finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Length(min=4,max=50,message = "Book name should be between 4 and 50 characters.")
    @NotNull
    @Column(unique = true,nullable=false)
    private String name;

    @NotNull
    @Column(nullable=false)
    private LocalDate releaseDate;

    @ManyToMany(mappedBy = "books",fetch = FetchType.EAGER)
    private Set<Writer> writers;
}
