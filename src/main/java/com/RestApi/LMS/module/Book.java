package com.RestApi.LMS.module;


import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "year_of_publication")
    private int yearOfPublication;

    @Column(name = "borrowed_status")
    private boolean borrowedBook;

    @ManyToOne
    @JoinColumn(name = "borrowed_by_id",referencedColumnName = "member_id")
    private User borrowedBy;

    public Book() {
    }

    public Book(int id, User borrowedBy, boolean borrowedBook, int yearOfPublication, String bookName, String authorName) {
        this.id = id;
        this.borrowedBy = borrowedBy;
        this.borrowedBook = borrowedBook;
        this.yearOfPublication = yearOfPublication;
        this.bookName = bookName;
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public User getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(User borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public boolean isBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(boolean borrowedBook) {
        this.borrowedBook = borrowedBook;
    }
}
