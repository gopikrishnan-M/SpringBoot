package com.kris.SecurityDemo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kris.SecurityDemo.Service.BooksService;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;
    private String name;
    private String author;
    private double price;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;
}
