package com.app.repository;

import com.app.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Book", path = "books")
    public interface BookRepository extends CrudRepository<Book, Integer> {
    public List<Book> findByName(String name);
    }
