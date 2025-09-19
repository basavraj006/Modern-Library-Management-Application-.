package com.RestApi.LMS.Controllers;

import com.RestApi.LMS.module.Book;
import com.RestApi.LMS.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Objectives
 * 1 GET all the available book
 * 2 POST the book
 * 3 DELETE/id the book With its id
 * 4 PATCH/id should update the book name with its id
 * 5 borrow book with user id, book id.
 * 6 return book with book id
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/books")
public class bookController {
    @Autowired
    private BookService bookService;

    // this is for checking health of bookController
    @GetMapping("/health")
    public String bookControllerHealthcheck(){
        return "Book controller health check is live";
    }

    // this is for Getting all the books
    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookService.getAllBook();
    }

    // this is for uploading a book
    @PostMapping("/save")
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    // this is for deleting book with its id
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int bookId){
        return bookService.deleteBook(bookId);
    }

    //this is for updating book
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        try {
            Book updatedBook = bookService.updateBook(id, book);
            return ResponseEntity.ok(updatedBook);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PatchMapping("/borrow/{userId}/{bookId}")
    public ResponseEntity<Book> borrowBook(@PathVariable("bookId") int bookId,@PathVariable("userId") int userId){
        Book BorrowedBook = bookService.borrowBook(bookId,userId);
        if (BorrowedBook!=null){
            return ResponseEntity.ok(BorrowedBook);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/return/{bookId}")
    public ResponseEntity<Book> returnBook(@PathVariable int bookId){
        Book ReturnedBook= bookService.returnBook(bookId);
        if (ReturnedBook!=null){
            return ResponseEntity.ok(ReturnedBook);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
}
