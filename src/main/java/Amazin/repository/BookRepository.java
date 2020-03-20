package Amazin.repository;

import Amazin.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "Book", path = "books")
    public interface BookRepository extends CrudRepository<Book, Integer> {
    public List<Book> findByName(String name);
    }
