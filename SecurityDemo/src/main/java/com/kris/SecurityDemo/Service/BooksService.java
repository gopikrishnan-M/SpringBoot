package com.kris.SecurityDemo.Service;

import com.kris.SecurityDemo.Model.Books;
import com.kris.SecurityDemo.Repository.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    @Autowired
    BooksRepo booksRepo;

    public List<Books> getBooks() {
        return booksRepo.findAll();
    }

    public Books getBookByName(String name) {
        return booksRepo.findByName(name);
    }

    public Optional<Books> getBookById(int id) {
        return booksRepo.findById(id);
    }

    public void addBook(Books book) {
        booksRepo.save(book);
    }

    public boolean removeBook(int id) {
        if(booksRepo.existsById(id)){
            booksRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
