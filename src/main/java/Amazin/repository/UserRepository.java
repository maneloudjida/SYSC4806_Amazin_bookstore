package Amazin.repository;

import Amazin.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
//@RepositoryRestResource(collectionResourceRel = "User", path = "users")
public interface UserRepository extends JpaRepository<User, Integer> {
    //User findByUsername(String username);
    User findByfname(String fname);
}
