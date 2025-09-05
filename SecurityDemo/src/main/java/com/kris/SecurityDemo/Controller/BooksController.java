package com.kris.SecurityDemo.Controller;

import com.kris.SecurityDemo.Model.Books;
import com.kris.SecurityDemo.Service.BooksService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//show one ,show all, add ,remove
@RestController
public class BooksController {
    @Autowired
    BooksService booksService;


    @GetMapping("/")
    public String greet(HttpServletRequest request){
        String sessionId=request.getSession().getId();
        return "Welcome to the Home Page" +
                "\n session id :"+ sessionId +
                "\n Menu :-" +
                "\n \t 1) showall" +
                "\n \t 2) showone/name" +
                "\n \t 3) showone/id" +
                "\n \t 4) addbook" +
                "\n \t 5) remove/id";
    }
    @GetMapping("/showall")
    public List<Books> getUsers(){
        return booksService.getBooks();
    }

    @GetMapping("/showone/name")
    public Books getBookByName(@RequestParam("name") String name){
        return booksService.getBookByName(name);
    }

    @GetMapping("/showone/{id}")
    public Optional<Books> getBookById(@PathVariable("id") int id){
        return booksService.getBookById(id);
    }

    @PostMapping("/addbook")
    public ResponseEntity<String> addBook(@RequestBody Books book){
        booksService.addBook(book);
        return ResponseEntity.ok("Book added sucessfuly");
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> removeBook(@PathVariable("id") int id){
        boolean removed=booksService.removeBook(id);
        if (removed) {
            return ResponseEntity.ok("book removed sucessfully");
        }
        return ResponseEntity.status(404).body("Boot not found with id: " + id);
    }


    @GetMapping("/token")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
