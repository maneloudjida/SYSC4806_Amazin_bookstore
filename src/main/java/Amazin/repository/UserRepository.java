package Amazin.repository;

import Amazin.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository<U extends User> extends JpaRepository<U, String> {
    Optional<U> findByUsername(String username);
    Boolean existsByUsername(String username);

}
