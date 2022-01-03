package com.aacademy.Finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name="writer")
public class Writer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true,nullable=false)
    private String name;

    @NotNull
    @Column(nullable=false)
    private Integer age;

    @NotNull
    @Column(nullable=false)
    private LocalDate dateBirth;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="writers_books",
            joinColumns = @JoinColumn(name="writer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="book_id",referencedColumnName = "id")
    )
    private Set<Book> books;
}
