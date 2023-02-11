package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private List<Book> bookList;
    private int id;

    public BookRepository(){
        bookList = new ArrayList<>();
        id=1;
    }

    public Book save(Book book){
        book.setId(id++);
        bookList.add(book);
         return book;
    }

    public Book findBookById(int id){
        for(Book book: bookList){
            if(book.getId()==id) return book;
        }
        return null;
    }

    public List<Book> findAll(){
        return bookList;
    }

    public void deleteBookById(int id){
        bookList.remove(id);
    }

    public void deleteAll(){
        bookList.clear();}

    public List<Book> findBooksByAuthor(String author){
        List<Book> ls= new ArrayList<>();
        for(Book book : bookList){
            if(book.getAuthor().equals(author))
                ls.add(book);
        }
        return ls;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> ls= new ArrayList<>();
        for(Book book : bookList){
            if(book.getGenre().equals(genre)) ls.add(book);
        }
        return ls;
    }
}
