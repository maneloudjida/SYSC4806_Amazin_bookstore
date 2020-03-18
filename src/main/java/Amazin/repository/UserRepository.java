package Amazin.repository;

import Amazin.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(collectionResourceRel = "User", path = "users")
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
