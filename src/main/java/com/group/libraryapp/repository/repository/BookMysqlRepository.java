package com.group.libraryapp.repository.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class BookMysqlRepository implements BookRepository {

    @Override
    public void saveBook() {
        System.out.println("MySql Repository");
    }
}
