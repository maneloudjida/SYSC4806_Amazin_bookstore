package Amazin.repository;

import Amazin.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "User", path = "users")
public interface UserRepository extends CrudRepository<User, Integer> {

}
