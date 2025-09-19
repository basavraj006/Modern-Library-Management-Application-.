package com.RestApi.LMS.service;

import com.RestApi.LMS.Repository.BookRepository;
import com.RestApi.LMS.Repository.UserRepository;
import com.RestApi.LMS.module.Book;
import com.RestApi.LMS.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Book> getAllBook(){
        return bookRepository.findAll(Sort.by(Sort.by(Sort.Direction.ASC,"id").toList()));
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public String deleteBook(int id){
        bookRepository.deleteById(id);
        return "Book with id "+id+" is deleted";
    }

    public Book updateBook(int id, Book book) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isEmpty()) {
            throw new RuntimeException("Book with id " + id + " not found");
        }

        Book savedBook = bookOptional.get();

        // update all fields (skip null checks if you want to replace completely)
        savedBook.setBookName(book.getBookName());
        savedBook.setAuthorName(book.getAuthorName());
        savedBook.setYearOfPublication(book.getYearOfPublication());

        return bookRepository.save(savedBook);
    }


    public Book borrowBook(int bookId, int userId){
        Book book =bookRepository.findById(bookId).orElseThrow(() ->new RuntimeException("Book not found"));
        User user= userRepository.findById(userId).orElseThrow(() ->new RuntimeException("user not found"));

        book.setBorrowedBy(user);
        book.setBorrowedBook(true);
        return bookRepository.save(book);
    }


    public Book returnBook(int bookId){
        Book book = bookRepository.findById(bookId).orElseThrow(() ->new RuntimeException("Book not found"));
        if (book!=null && book.isBorrowedBook()){
            book.setBorrowedBy(null);
            book.setBorrowedBook(false);
            return saveBook(book);
        }
        return null;
    }


}
