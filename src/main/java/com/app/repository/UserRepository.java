package com.app.repository;

import com.app.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "User", path = "users")
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByemail(String email);

}