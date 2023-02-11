package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id){
        Book presentbook = bookService.findBookById(id);
        return new ResponseEntity<>(presentbook,HttpStatus.OK);
    }


    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books=bookService.findAllBooks();
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Deleted Book With Id="+id,HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity<String> deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("All Books Removed",HttpStatus.OK);
    }

    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam String author){

        return new ResponseEntity<>(bookService.findBooksByAuthor(author),HttpStatus.OK);
    }
    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam String genre){

        return new ResponseEntity<>(bookService.findBooksByGenre(genre),HttpStatus.OK);
    }
}
