package com.group.libraryapp.repository.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public class BookMemoryRepository implements BookRepository {

//    private final List<Book> books = new ArrayList<>();

    public void saveBook() {
        System.out.println("Memory Repository");
    }
}
