package Amazin.repository;

import Amazin.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface BookRepository extends JpaRepository<Book, String> {

    }
