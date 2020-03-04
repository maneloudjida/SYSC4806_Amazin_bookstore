package Amazin.repository;

import Amazin.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

    @RepositoryRestResource(collectionResourceRel = "Book", path = "books")
    public interface BookRepository extends CrudRepository<Book, Integer> {

    }
