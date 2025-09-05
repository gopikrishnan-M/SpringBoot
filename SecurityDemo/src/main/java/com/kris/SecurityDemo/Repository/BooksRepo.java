package com.kris.SecurityDemo.Repository;

import com.kris.SecurityDemo.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepo extends JpaRepository<Books,Integer> {

    Books findByName(String name);
}
