package Amazin.repository;

import Amazin.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "User", path = "users")
public interface UserRepository extends CrudRepository<User, Integer> {

}
