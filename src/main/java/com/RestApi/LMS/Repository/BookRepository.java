package com.RestApi.LMS.Repository;

import com.RestApi.LMS.module.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Book, Integer> {
}
