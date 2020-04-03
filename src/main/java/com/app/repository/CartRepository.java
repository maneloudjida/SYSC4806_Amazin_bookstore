package com.app.repository;

import com.app.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Cart", path = "carts")
public interface CartRepository extends CrudRepository<Cart, Integer>{
}
